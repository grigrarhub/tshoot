package ru.miac.FedReg.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.miac.FedReg.controller.EsmoController;
import ru.miac.FedReg.model.*;
import ru.miac.FedReg.repository.CodRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CodMo {
    private static final Logger log = Logger.getLogger(CodMo.class);


    @Autowired
    private CodRepository codRepository;
    @Autowired
    private EsmoService esmoService;
    @Autowired
    EsmoController esmoController;

    public List<DirectionForProMed> getDirectionsToSend(){
        List<DirectionForProMed> list = new ArrayList<>();
        List<DirectionOnCod> directionsOnCod = codRepository.getDirections();
        for (DirectionOnCod x : directionsOnCod) {
            DirectionForProMed direction = esmoService.setEnv(x);
            list.add(direction);
        }

        return list;
    }


}
