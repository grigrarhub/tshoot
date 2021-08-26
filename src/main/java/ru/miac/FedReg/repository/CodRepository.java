package ru.miac.FedReg.repository;

import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import ru.miac.FedReg.mapper.DirectionMapper;
import ru.miac.FedReg.model.DirectionOnCod;

import java.util.List;


@Component
@RequiredArgsConstructor
public class CodRepository {
    private static final Logger log = Logger.getLogger(CodRepository.class);
    private static JdbcTemplate jdbcTemplate;
    @Autowired
    private DirectionMapper directionMapper;
    @Value("${spring.datasource.url}")
    private  String url;
    @Value("${spring.datasource.username}")
    private  String username;
    @Value("${spring.datasource.password}")
    private  String password;

    private String query = "SELECT\n" +
            " lbr.Date_Direction,\n" +
            "      lbr.[Number],\n" +
            "      lbr.Priority,\n" +
            "      lbr.Pat_SS,\n" +
            "      lbr.DOCT_SS,\n" +
            "      lbr.rf_kl_ProfitTypeID,\n" +
            "      lbr.rf_kl_TipOMSID ,\n" +
            "lbr.DOCT_FIO, \n" +
            "      oms.DS ,\n" +
            "      lbr.Priority,\n" +
            "      info.Lic as Sender,\n" +
            "      inf.Lic as LpuIn,\n" +
            "      qqq.DateReceipt,\n" +
            "       qqq.rf_BioMID ,qqq.IsFailed , qqq.IsFormalin ,qqq.IsPackageSaved, qqq.rf_LaboratoryResearchGUID, lldt.Name,qqq.Value \n" +
            "FROM lbr_LaboratoryResearch lbr JOIN rpt_lpuInfo info ON lbr.rf_LPUSenderID = info.LPUID \n" +
            "JOIN rpt_lpuInfo inf ON lbr.rf_LPUID = inf.LPUID \t\n" +
            "JOIN Oms_mkb oms ON lbr.rf_MKBID = oms.MKBID " +
            "JOIN (select \n" +
            "lr2.DateReceipt, \n" +
            "ls.rf_BioMID ,\n" +
            "ls.IsFailed ,\n" +
            "ls.IsFormalin ,\n" +
            "ls.IsPackageSaved,\n" +
            "lr2.rf_LaboratoryResearchGUID, \n" +
            "lov.Value \n" +
            "\tfrom lbr_Sample ls Join lbr_Research lr2 on ls.rf_ResearchID = lr2.ResearchID" +
            " JOIN lbr_OptionValue lov on lov.rf_SampleID = ls.SampleID WHERE lov.rf_OptionID=2) as qqq on lbr.GUID = qqq.rf_LaboratoryResearchGUID \n" +
            "JOIN lbr_LabDirectionType lldt on lbr.rf_LabDirectionTypeID = lldt.LabDirectionTypeID \n" +
            "WHERE lbr.Date_Direction >'2021-07-07 00:00:00' and lbr.rf_LabDirectionTypeID=3" +
            "";

    public JdbcTemplate setDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:sqlserver://10.3.126.60:1433;databaseName=cod_MO");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    public List<DirectionOnCod> getDirections(){
        return setDataSource().query(query,directionMapper);
    }
}
