package ru.miac.FedReg.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.miac.FedReg.model.DirectionOnCod;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DirectionMapper implements RowMapper<DirectionOnCod> {
    @Override
    public DirectionOnCod mapRow(ResultSet result, int i) throws SQLException {
        return new DirectionOnCod()
                .setDate_Direction(result.getString("Date_Direction"))
                .setNumber(result.getString("Number"))
                .setPriority(result.getInt("Priority"))
                .setDS(result.getString("DS"))
                .setPat_SS(result.getString("Pat_SS"))
                .setDOCT_SS(result.getString("DOCT_SS"))
                .setDate_Direction(result.getString("Date_Direction"))
                .setNumber(result.getString("Number"))
                .setPriority(result.getInt("Priority"))
                .setSender(result.getString("Sender"))
                .setLpuIn(result.getString("LpuIn"))
                .setDateReceipt(result.getString("DateReceipt"))
                .setRf_BioMID(result.getInt("rf_BioMID"))
                .setIsFailed(result.getInt("IsFailed"))
                .setIsFormalin(result.getInt("IsFormalin"))
                .setIsPackageSaved(result.getInt("IsPackageSaved"))
                .setName(result.getString("Name"))
                .setValue(result.getString("Value"))
                .setDOCT_FIO(result.getString("DOCT_FIO"));
    }
}
