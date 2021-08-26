package ru.miac.FedReg.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.miac.FedReg.dto.MedWorker;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedWorckerMapper implements RowMapper<MedWorker> {

    @Override
    public MedWorker mapRow(ResultSet resultSet, int i) throws SQLException {
        return new MedWorker().setId(resultSet.getLong("id"));
    }
}
