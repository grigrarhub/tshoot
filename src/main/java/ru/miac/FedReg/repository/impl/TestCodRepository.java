package ru.miac.FedReg.repository.impl;

import org.springframework.stereotype.Repository;
import ru.miac.FedReg.entity.DirectionOnCod;
import ru.miac.FedReg.repository.CodRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Repository("testCodRepository")
public class TestCodRepository implements CodRepository {

    private final static DateTimeFormatter codFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

    @Override
    public List<DirectionOnCod> getDirections() {
        return Arrays.asList(
                new DirectionOnCod()
                        .setComment("setComment")
                        .setDateDirection(LocalDateTime.now().format(codFormatter))
                        .setNumber("26300122-709446")
                        .setPriority(0)
                        .setPatFamily("НУРЕТДИНОВ")
                        .setPatName("ВАЛЕРИЙ")
                        .setPatOt("РИФОВИЧ")
                        .setPatW(1)
                        .setPatSS("025-478-701 63")
                        .setPatNPOL("5056140828001798")
                        .setDoctss("142-721-787 54")
                        .setSender("1.2.643.5.1.13.13.12.2.50.11329.0.327434")
                        .setLpuIn("1.2.643.5.1.13.13.12.2.50.11329.0.326626")
                        .setDs("G93.4")
                        .setDateReceipt("")
                        .setRfBioMID(1)
                        .setIsFailed(0)
                        .setFormalin(true)
                        .setIsPackageSaved(0)
                        .setName("Патоморфология")
                        .setDoctFio("Конченкова Анна Васильевна")
                        .setRfKlProfitTypeID(0)
                        .setValue("Пункционная биопсия")
                        .setOid("1.2.643.5.1.13.13.12.2.50.11329.0.327434.289518")
                        .setAdditionalComment("setAdditionalComment")
                        .setPreviousTreatment("setPreviousTreatment"));
    }
}
