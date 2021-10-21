package ru.miac.FedReg.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import ru.miac.FedReg.controller.EsmoController;
import ru.miac.FedReg.dto.DirectionForProMed;
import ru.miac.FedReg.dto.Response;
import ru.miac.FedReg.entity.DirectionOnCod;
import ru.miac.FedReg.entity.Histologic;
import ru.miac.FedReg.repository.CodRepository;
import ru.miac.FedReg.repository.HistologicRepository;
import ru.miac.FedReg.repository.impl.ProMedRepositoryImpl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j
@Service
@RequiredArgsConstructor
public class CodService {
    private final static DateTimeFormatter codFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

    private final CodRepository testCodRepository; //testCodRepository codRepositoryImpl
    private final HistologicRepository esmoRepository;
    private final EsmoController esmoController;
    private final EsmoService esmoService;
    private final ProMedRepositoryImpl proMedRepositoryImpl;

    public List<Response> getDirectionsToSend() throws IOException {
        return directionEsmoFromProMeds(testCodRepository.getDirections());
    }

    public List<Response> directionEsmoFromProMeds(List<DirectionOnCod> directionsOnCod){
        esmoController.setApikay();
        List<Response> responses = new ArrayList<>();
        Response response = null;
        for (DirectionOnCod x : directionsOnCod) {
            System.out.println(x);
            Histologic responseForDB;
            Optional<Histologic> optionalHistologic = esmoRepository.findAllByNum(x.getNumber());
            responseForDB = optionalHistologic.orElseGet(Histologic::new);
            if(!responseForDB.isIssend()){
                try {
                    responseForDB.setDateRun(LocalDateTime.now());
                    responseForDB.setDataCod(x.toString()).setNum(x.getNumber());
                    DirectionForProMed direction = esmoService.setEnv(x);
                    responseForDB.setDataProMed(direction.getJson());
                    response = esmoController.postEvnDirection(direction);
                    responseForDB.setErrorcod(response.getErrorCode());
                    if(!response.getErrorCode().equals("0")) {
                        responseForDB.setErrormsg(response.toString());
                        if(response.getErrorCode().equals("500"))
                            responseForDB.setIssend(true);
                    } else {
                        responseForDB.setIssend(true).setDateSend(LocalDateTime.now());
                        proMedRepositoryImpl.updataLpu(direction.getLpuSectionId(),direction.getEvnDirectionNum());
                        proMedRepositoryImpl.updataEvnDirectionHistologicClinicalData(x.getAdditionalComment(),response.getData().getEvnDirectionId());
                        proMedRepositoryImpl.updataEvnDirectionHistologicPredOperTreat(x.getPreviousTreatment(),response.getData().getEvnDirectionId());
                    }
                    esmoRepository.save(responseForDB);
                } catch (Exception e) {
                    esmoRepository.save(responseForDB.setErrormsg(e.getMessage()));
                }
            }
            responses.add(response);
        }
        return responses;
    }
}
