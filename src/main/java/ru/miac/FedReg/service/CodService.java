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

    private final CodRepository codRepositoryImpl; //testCodRepository codRepositoryImpl
    private final HistologicRepository esmoRepository;
    private final EsmoController esmoController;
    private final EsmoService esmoService;
    private final ProMedRepositoryImpl proMedRepositoryImpl;

    public void getDirectionsToSend() throws IOException {
         directionEsmoFromProMeds(codRepositoryImpl.getDirections()); //todo codRepositoryImpl.getDirections() возвращает все направления из ЦОДа
    }
    //todo directionsOnCod это все направления из ЦОДа
    public List<Response> directionEsmoFromProMeds(List<DirectionOnCod> directionsOnCod){
        esmoController.setApikay();
        List<Response> responses = new ArrayList<>();
        Response response = null;
        for (DirectionOnCod x : directionsOnCod) {
            Histologic responseForDB;
            //todo поиск в базе лога направления по номеру
            Optional<Histologic> optionalHistologic = esmoRepository.findAllByNum(x.getNumber());
            responseForDB = optionalHistologic.orElseGet(Histologic::new);
            //todo проверка статуса отправки
            if(!responseForDB.isIssend()){
                //todo если направление не было отправлено, попытаться еше раз
                try {
                    responseForDB.setDateRun(LocalDateTime.now());
                    responseForDB.setDataCod(x.toString()).setNum(x.getNumber());
                    //todo преобразование данных из ЦОД для отправления на АРИ ПроМед
                    DirectionForProMed direction = esmoService.setEnv(x);
                    responseForDB.setDataProMed(direction.getJson());
                    //todo отправка данных, ответ записываем в базу
                    response = esmoController.postEvnDirection(direction);
                    responseForDB.setErrorcod(response.getErrorCode());
                    //todo проверка статуса
                    if(!response.getErrorCode().equals("0")) {
                        responseForDB.setErrormsg(response.toString());
                        if(response.getErrorCode().equals("500"))
                            responseForDB.setIssend(true);
                    } else {
                        //todo если направление создалось успешно, добавляем к нему комментарии
                        responseForDB.setIssend(true).setDateSend(LocalDateTime.now());
                        //todo Апи записывает не корректно, поэтому записываем сами
                        proMedRepositoryImpl.updataLpu(direction.getLpuSectionId(),direction.getEvnDirectionNum());

                        //todo добавляем к нему комментарии
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
