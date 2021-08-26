package ru.miac.FedReg.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.miac.FedReg.model.Diag;
import ru.miac.FedReg.model.DirectionOnCod;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DiagMapper implements RowMapper<Diag> {
    @Override
    public Diag mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Diag()
                .setDiag_id(resultSet.getInt("Diag_id"));
    }
}
