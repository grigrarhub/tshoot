package ru.miac.FedReg.repository;

import ru.miac.FedReg.entity.DirectionOnCod;

import java.io.IOException;
import java.util.List;

public interface CodRepository {
    List<DirectionOnCod> getDirections() throws IOException;
}
