package ru.miac.FedReg.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component

public class ProMedMapper implements RowMapper<String> {
    @Override
    public String mapRow(ResultSet resultSet, int i) throws SQLException {
        return resultSet.toString();
    }
}
