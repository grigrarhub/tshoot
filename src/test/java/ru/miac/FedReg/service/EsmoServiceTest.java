package ru.miac.FedReg.service;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.miac.FedReg.controller.DirectionController;
import ru.miac.FedReg.controller.EsmoController;
import ru.miac.FedReg.dto.DirectionForProMed;
import ru.miac.FedReg.entity.DirectionOnCod;
import ru.miac.FedReg.repository.impl.CodRepositoryImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class EsmoServiceTest {
    @Autowired
    EsmoService esmoService;

    @MockBean
    EsmoController esmoController;
    @MockBean
    DirectionController directionController;
    @MockBean
    CodRepositoryImpl codRepository;
    @Test
    void setEnv() {
        Assertions.assertNotNull(esmoService.setEnv(new DirectionOnCod()
                .setComment("Тест")
                .setDateDirection("2021-09-20 00:00:00.0")
                .setNumber("41010100-502112")
                .setPriority(1)
                .setPatFamily("Фамилия")
                .setPatName("Имя")
                .setPatOt("Отчество")
                .setPatW(1)
                .setPatSS("025-478-701 63")
                .setPatNPOL("5056140828001798")
                .setDoctss("142-721-787 54")
                .setSender("1.2.643.5.1.13.13.12.2.50.11329.0.327434")
                .setLpuIn("1.2.643.5.1.13.13.12.2.50.11329.0.326626")
                .setDs("")
                .setDateReceipt("")
                .setRfBioMID(1)
                .setIsFailed(0)
                .setFormalin(true)
                .setIsPackageSaved(0)
                .setName("Патоморфология")
                .setDoctFio("Конченкова Анна Васильевна")
                .setRfKlProfitTypeID(0)
                .setValue("Пункционная биопсия")
                .setOid("1.2.643.5.1.13.13.12.2.50.11329.0.327434.289518")));
    }
}