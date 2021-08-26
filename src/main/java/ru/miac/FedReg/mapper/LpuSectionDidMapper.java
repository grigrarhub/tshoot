package ru.miac.FedReg.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.miac.FedReg.dto.LpuSection_did;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LpuSectionDidMapper implements RowMapper<LpuSection_did> {
    @Override
    public LpuSection_did mapRow(ResultSet resultSet, int i) throws SQLException {
        return new LpuSection_did().setLpuSection_id(resultSet.getLong("LpuSection_id"));
    }
}
