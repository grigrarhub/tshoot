package ru.miac.FedReg.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.miac.FedReg.entity.DirectionOnCod;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DirectionMapper implements RowMapper<DirectionOnCod> {
    @Override
    public DirectionOnCod mapRow(ResultSet result, int i) throws SQLException {
        return new DirectionOnCod()
                .setDateDirection(result.getString("Date_Direction"))
                .setNumber(result.getString("Number"))
                .setPriority(result.getInt("Priority"))
                .setDs(result.getString("DS"))
                .setPatSS(result.getString("Pat_SS"))
                .setDoctss(result.getString("DOCT_SS"))
                .setDateDirection(result.getString("Date_Direction"))
                .setNumber(result.getString("Number"))
                .setPriority(result.getInt("Priority"))
                .setSender(result.getString("Sender"))
                .setLpuIn(result.getString("LpuIn"))
                .setDateReceipt(result.getString("DateReceipt"))
                .setRfBioMID(result.getInt("rf_BioMID"))
                .setIsFailed(result.getInt("IsFailed"))
                .setIsPackageSaved(result.getInt("IsPackageSaved"))
                .setName(result.getString("Name"))
                .setValue(result.getString("Value"))
                .setDoctFio(result.getString("DOCT_FIO"))
                .setPatNPOL(result.getString("Pat_N_POL"))
                .setPatName(result.getString("Pat_Name"))
                .setPatFamily(result.getString("Pat_Family"))
                .setPatOt(result.getString("Pat_Ot"))
                .setPatW(result.getInt("Pat_W"))
                .setPatBirthday(result.getDate("Pat_Birthday"))
                .setComment(result.getString("Comment"))
                .setOid(result.getString("OID"))
                .setFormalin(result.getInt("isFormalin")==1)
                .setIsPreviousResearchPerformed(result.getInt("IsPreviousResearchPerformed"))
                .setAdditionalComment(result.getString("AdditionalComment"))
                .setPreviousTreatment(result.getString("PreviousTreatment"));
    }
}
