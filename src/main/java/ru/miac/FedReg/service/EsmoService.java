package ru.miac.FedReg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.miac.FedReg.controller.EsmoController;
import ru.miac.FedReg.model.*;
import ru.miac.FedReg.repository.ProMedRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EsmoService {
    @Autowired
    private EsmoController esmoController;
    @Autowired
    private ProMedRepository proMedRepository;

    private final static DateTimeFormatter codFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
    private final static DateTimeFormatter promedFormatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final static DateTimeFormatter promedFormatterDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    //LocalDateTime.parse(x.getDate_Direction(),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

    public DirectionForProMed setEnv(DirectionOnCod x) {
        DirectionForProMed forProMed=new DirectionForProMed();
        forProMed.setPerson_id(esmoController.getPersonId(x.getPat_SS()))
                .setEvnDirection_Num(x.getNumber())
                .setEvnDirection_setDate(
                        LocalDateTime.parse(x.getDate_Direction(),codFormatter)
                                .format(promedFormatterDate)) //todo: date
                .setPayType_id(x.getRf_kl_ProfitTypeID()>1?(199+x.getRf_kl_ProfitTypeID()):(205))
                .setDiag_id(proMedRepository.getDiagID(x.getDS()))
                .setLpu_sid(esmoController.getLpuid(isPrehospDirect(x.getSender())))
                .setLpu_did(esmoController.getLpuid(isPrehospDirect(x.getLpuIn())))
                .setLpu_aid(esmoController.getLpuid(isPrehospDirect(x.getLpuIn())))
                .setMedPersonal_id(proMedRepository.getMedstaf(esmoController.getPersonId(x.getDOCT_SS())))
                .setMedPersonalFIO(x.getDOCT_FIO())
                .setEvnDirectionHistologic_IsUrgent(x.getPriority()==1?1:0)
                .setHistologicMaterial_id(x.getValue().contains("биопсия")?1:2)
                .setBiopsyDT(
                        LocalDateTime.parse(x.getDate_Direction(),codFormatter)
                                .format(promedFormatterDateTime)) //todo: date
                .setEvn_didDT(
                        LocalDateTime.parse(x.getDate_Direction(),codFormatter)
                                .format(promedFormatterDateTime))//todo: date
                .setBiopsyOrder_id(1)
                .setEvnDirection_Descr(x.getComment());
        LpuSectionAndProfil profil = proMedRepository.getLpuSectionAndProfil(forProMed.getLpu_sid());
        LpuSectionAndProfil profil2 = proMedRepository.getLpuSectionAndProfil(forProMed.getLpu_did());
        System.out.println(profil+" "+profil2);
        forProMed.setLpuSection_id(profil.getLpuSection_id());
        forProMed.setLpuSectionProfile_id(profil2.getLpuSectionProfile_id());
        forProMed.setMedStaffFact_id(proMedRepository.getMedstafFact(forProMed.getMedPersonal_id()));
        System.out.println(forProMed);
        return forProMed;
    }
    private String isPrehospDirect(String lpu){

        Pattern pattern = Pattern.compile("\\d{1,}.\\d{1,}.\\d{1,}.\\d{1,}.\\d{1,}.\\d{1,}.\\d{1,}.\\d{1,}.\\d{1,}.\\d{1,}.\\d{1,}");
        Matcher matcher = pattern.matcher(lpu);
        while(matcher.find())
            lpu = matcher.group();
        return lpu;
    }

}
