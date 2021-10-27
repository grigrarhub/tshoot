package ru.miac.FedReg.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.miac.FedReg.controller.EsmoController;
import ru.miac.FedReg.dto.DirectionForProMed;
import ru.miac.FedReg.dto.LpuSection;
import ru.miac.FedReg.dto.MedWorker;
import ru.miac.FedReg.dto.PersonForProMed;
import ru.miac.FedReg.entity.DirectionOnCod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class EsmoService {

    private final EsmoController esmoController;

    private final static DateTimeFormatter codFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
    private final static DateTimeFormatter promedFormatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final static DateTimeFormatter promedFormatterDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    //todo объект создается из объекта ЦОД при помощи АРИ промеда
    public DirectionForProMed setEnv(DirectionOnCod x) {
        //todo при добавлении данных, необхоимые поля добавить в DirectionForProMed
        DirectionForProMed forProMed=new DirectionForProMed();

        forProMed.setEvnDirectionNum(x.getNumber())
                .setEvnDirectionSetDate(
                        LocalDateTime.parse(x.getDateDirection(), codFormatter)
                                .format(promedFormatterDate)) //todo: date
                .setDiagId(esmoController.getDiagID(x.getDs()).orElse(0))
                .setLpuSid(esmoController.getLpuid(isPrehospDirect(x.getSender())).orElse(0L))
                .setLpuDid(esmoController.getLpuid(isPrehospDirect(x.getLpuIn())).orElse(0L))
                .setLpuAid(esmoController.getLpuid(isPrehospDirect(x.getLpuIn())).orElse(0L))
                .setMedpersonalfio(x.getDoctFio())
                .setEvnDirectionDescr(x.getComment())
                .setEvnDirectionHistologicIsUrgent(x.getPriority()+1)
                .setHistologicMaterialId(x.getValue().contains("биопсия") ? 1 : 2)
                .setBiopsyOrderId(x.getIsPreviousResearchPerformed()>1?2:1)
                .setBiopsyDT(
                        LocalDateTime.parse(x.getDateDirection(), codFormatter)
                                .format(promedFormatterDateTime)) //todo: date
                .setEvnDidDT(
                        LocalDateTime.parse(x.getDateDirection(), codFormatter)
                                .format(promedFormatterDateTime))//todo: date
                .setBiopsyOrderId(1)
                .setEvnDirectionDescr(x.getComment())
                .setPrescriptionType_id(11)
                .setLpuSectionProfileId(20000348)
                .setIsPlaceSolFormalin(x.isFormalin() ? 1 : 0)
                .setPayTypeId(x.getRfKlProfitTypeID() > 1 ? (199 + x.getRfKlProfitTypeID()) : (205));
        Optional<LpuSection> optionalLpuSection = esmoController.getLpuSectionId(x.getOid());
        if (optionalLpuSection.isPresent()) {
            LpuSection lpuSection = optionalLpuSection.get();
            forProMed.setLpuSectionId(lpuSection.getLpuSectionId())
                    .setLpuUnitTypeId(lpuSection.getLpuUnitTypeId())
                    .setLpuSectionName(lpuSection.getLpuSectionName());
        }

        Optional<MedWorker> optionalMedWorker =  esmoController.getMedWorker(x.getDoctss(), forProMed.getLpuSid());
        if (optionalMedWorker.isPresent()) {
            MedWorker medWorker = optionalMedWorker.get();
            forProMed.setMedPersonalId(medWorker.getMedWorker_id())
                    .setMedStaffFactId(medWorker.getId());
        }

        long personId = esmoController.getPersonId(x.getPatSS()).orElse(esmoController.getPersonByPolis(x.getPatNPOL()).orElse(0L));

        if (personId==0)
            personId = esmoController.createPerson(
                    new PersonForProMed().setPersonSurNameSurName(x.getPatFamily())
                            .setPersonFirNameFirName(x.getPatName())
                            .setPersonSecNameSecName(x.getPatOt())
                            .setPersonBirthDayBirthDay(x.getPatBirthday())
                            .setPersonSexId(x.getPatW()+1)
                            .setPersonSnilsSnils(x.getPatSS())
                            .setSocStatusId(10000114)
            ).orElse(0L);
        forProMed.setPersonId(personId);

        return forProMed;
    }

    private String isPrehospDirect(String lpu) {
        try {
            Pattern pattern = Pattern.compile("\\d{1,}.\\d{1,}.\\d{1,}.\\d{1,}.\\d{1,}.\\d{1,}.\\d{1,}.\\d{1,}.\\d{1,}.\\d{1,}.\\d{1,}");

            Matcher matcher = pattern.matcher(lpu);
            while(matcher.find())
                lpu = matcher.group();
            return lpu;}
        catch (Exception e){
            return "";
        }
    }
}
