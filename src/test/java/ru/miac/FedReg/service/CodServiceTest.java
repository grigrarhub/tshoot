package ru.miac.FedReg.service;


import lombok.RequiredArgsConstructor;
import org.jsoup.Connection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.miac.FedReg.controller.EsmoController;
import ru.miac.FedReg.dto.Response;
import ru.miac.FedReg.repository.CodRepository;
import ru.miac.FedReg.repository.HistologicRepository;
import ru.miac.FedReg.repository.impl.ProMedRepositoryImpl;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CodServiceTest {

    @Autowired
    private   CodService codService;
    @Autowired
    private  CodRepository testCodRepository; //testCodRepository codRepositoryImpl
    @Test
    void getDirectionsToSend() {

    }

    @Test
    void directionEsmoFromProMeds() throws IOException {
        List<Response> responses = codService.directionEsmoFromProMeds(testCodRepository.getDirections());
        Assertions.assertNotNull(responses.get(0));
      System.out.println(responses);//Response{error_code=500,error_msg=Направление с указанным номером для данного пациента уже создано}

    }
}