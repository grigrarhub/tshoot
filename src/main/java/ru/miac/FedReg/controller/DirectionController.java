package ru.miac.FedReg.controller;

import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.miac.FedReg.model.DirectionForProMed;
import ru.miac.FedReg.model.Response;
import ru.miac.FedReg.repository.CodRepository;
import ru.miac.FedReg.service.CodMo;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DirectionController {
    private static final Logger log = Logger.getLogger(DirectionController.class);
    @Autowired
    private final CodRepository codRepository;
    @Autowired
    private final CodMo сodMo;

    @Autowired
    private EsmoController esmoController;

    @GetMapping("/test")
    public List<DirectionForProMed> getEvn() {
        log.info("Start exchange at "+ LocalDateTime.now());
        log.info("Request and prepare directions...");
        List<DirectionForProMed> list = сodMo.getDirectionsToSend();

        log.info("Got "+list.size()+" directions to send.");
        int success = sendDirectionsToPromed(list);
        log.info("Sent "+success+" directions");

        return list;
    }

    private int sendDirectionsToPromed(List<DirectionForProMed> list) {
        int success = 0;
        for (DirectionForProMed direction : list) {
            Response response = esmoController.postEvnDirection(direction);
            if(response.getError_code()==0) {
                success++;
                log.info(response.getData().toString());
            }else {
                log.error(response.toString()+"\n"+direction);
            }
        }
        return success;
    }

}
