package ru.miac.FedReg.mapper;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import ru.miac.FedReg.model.LpuSectionAndProfil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LpuAndProfilMapper implements RowMapper<LpuSectionAndProfil> {
    @Override
    public LpuSectionAndProfil mapRow(ResultSet resultSet, int i) throws SQLException {
        return new LpuSectionAndProfil().setLpuSection_id(resultSet.getLong("LpuSection_id"))
                .setLpuSectionProfile_id(resultSet.getLong("LpuSectionProfile_id"));
    }
}
