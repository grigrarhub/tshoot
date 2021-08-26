package ru.miac.FedReg.repository;

import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import ru.miac.FedReg.dto.LpuSection_did;
import ru.miac.FedReg.dto.MedWorker;
import ru.miac.FedReg.mapper.*;
import ru.miac.FedReg.model.*;

import java.sql.ResultSet;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProMedRepository {
    private static final Logger log = Logger.getLogger(ProMedRepository.class);
    private static NamedParameterJdbcTemplate jdbcTemplate;
    private static JdbcTemplate jdbcTemplate1;
    @Autowired
    private ProMedMapper proMedMapper;
    @Autowired
    private PersonEvnMapper personEvnMapper;
    @Value("${ProMed.url}")
    private  String url;
    @Value("${ProMed.username}")
    private  String username;
    @Value("${ProMed.password}")
    private  String password;
    MapSqlParameterSource params;
    private String query = "SELECT * FROM Evn e WHERE e.Evn_id = 104 ;";

    public DriverManagerDataSource setDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    public int insertPersonEnv(PersonEvn personEvn) {
        params = new MapSqlParameterSource();
        params.addValue("Server_id",personEvn.getServer_id()).addValue("Person_id",personEvn.getPerson_id())
                .addValue("PersonEvnClass_id",personEvn.getPersonEvnClass_id());
        jdbcTemplate = new NamedParameterJdbcTemplate(setDataSource());
       return jdbcTemplate.execute("INSERT into PersonEvn (Server_id,Person_id,PersonEvnClass_id)\n" +
                "OUTPUT inserted.PersonEvn_id\n" +
                "values (:Server_id,:Person_id,:PersonEvnClass_id);", params, (preparedStatement) -> {
           ResultSet resultSet = preparedStatement.executeQuery();
           resultSet.next();
           return resultSet.getInt("PersonEvn_id");
       });
    }

    public long insertEvn(Evn evn) {
        params = new MapSqlParameterSource();
        params.addValue("Lpu_id",evn.getLpuId())
                .addValue("EvnClass_id",evn.getEvnClass_id())
                .addValue("Server_id",evn.getServer_id())
                .addValue("PersonEvn_id",evn.getPersonEvn_id())
                .addValue("Evn_setDT",evn.getEvn_setDT())
                .addValue("Evn_insDT",evn.getEvn_insDT())
                .addValue("Evn_updDT",evn.getEvn_updDT())
                .addValue("Evn_Index",evn.getEvn_Index())
                .addValue("Evn_Count",evn.getEvn_Count())
                .addValue("Person_id",evn.getPerson_id()).addValue("Evn_deleted",1);
        jdbcTemplate = new NamedParameterJdbcTemplate(setDataSource());

        return  jdbcTemplate.execute("INSERT into Evn (Lpu_id,"+
                " EvnClass_id," +
                " Server_id," +
                " PersonEvn_id," +
                " Evn_setDT," +
                " Evn_insDT," +
                " Evn_updDT," +
                " Evn_Index," +
                " Evn_Count," +
                " Person_id)," +
                "Evn_deleted\n" +
                "OUTPUT inserted.Evn_id\n" +
                "values (" +
                ":Lpu_id,:EvnClass_id,:Server_id,:PersonEvn_id,:Evn_setDT,:Evn_insDT,:Evn_updDT,:Evn_Index,:Evn_Count,:Person_id,:Evn_deleted);", params, (preparedStatement) -> {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getLong("Evn_id");
        });
    }

    public void insertEvnDirection(EvdDirection evdDirection) {
        jdbcTemplate = new NamedParameterJdbcTemplate(setDataSource());

        params = new MapSqlParameterSource();
        params.addValue("EvnDirection_id",evdDirection.getEvnDirection_id())
                .addValue("Lpu_did",evdDirection.getLpu_did())
                .addValue("Lpu_sid",evdDirection.getLpu_sid())
                .addValue("Evn_id",evdDirection.getEvn_id())
                .addValue("DirType_id",evdDirection.getDirType_id())
                .addValue("Diag_id",evdDirection.getDiag_id())
                .addValue("MedPersonal_id",evdDirection.getMedPersonal_id())
                .addValue("LpuSection_did",evdDirection.getLpuSection_did())
                .addValue("EvnDirection_Num",evdDirection.getEvnDirection_Num());
        String q= "INSERT into EvnDirection ( " +
                "EvnDirection_id," +
                " Lpu_did," +
                " Lpu_sid," +
                " Evn_id," +
                " DirType_id," +
                " Diag_id,";
        if    (evdDirection.getLpuSection_id()!=0){
            params.addValue("LpuSection_id",evdDirection.getLpuSection_id());
            q+= " LpuSection_id," +
                    " MedPersonal_id,"+
                    " LpuSection_did," +
                    " EvnDirection_Num)"+
                    "values ( :EvnDirection_id,:Lpu_did,:Lpu_sid,:Evn_id,:DirType_id,:Diag_id,:LpuSection_id,:MedPersonal_id," +
                    ":LpuSection_did,:EvnDirection_Num);";

        }else {
            q+=  " MedPersonal_id,"+
                    " LpuSection_did," +
                    " EvnDirection_Num)"+
                    "values ( :EvnDirection_id,:Lpu_did,:Lpu_sid,:Evn_id,:DirType_id,:Diag_id,:MedPersonal_id," +
                    ":LpuSection_did,:EvnDirection_Num);";
        }

        jdbcTemplate.update(q, params);


    }

    public void insertEnvHisto(EvnDirectionHistologic evnDirectionHistologic) {

        params = new MapSqlParameterSource();
        params.addValue("EvnDirection_id",evnDirectionHistologic.getEvnDirection_id())
                .addValue("EvnDirectionHistologic_id",evnDirectionHistologic.getEvnDirectionHistologic_id())
                .addValue("EvnDirectionHistologic_IsUrgent",evnDirectionHistologic.getEvnDirectionHistologic_IsUrgent())
                .addValue("Lpu_aid",evnDirectionHistologic.getLpu_aid())
                .addValue("HistologicMaterial_id",evnDirectionHistologic.getHistologicMaterial_id())
                .addValue("BiopsyOrder_id",evnDirectionHistologic.getBiopsyOrder_id())
                .addValue("EvnDirectionHistologic_IsPlaceSolFormalin",evnDirectionHistologic.getEvnDirectionHistologic_IsPlaceSolFormalin());
        System.out.println(params.toString());
        jdbcTemplate.update("INSERT into EvnDirectionHistologic ( EvnDirection_id," +
                "EvnDirectionHistologic_id," +
                "   EvnDirectionHistologic_IsUrgent," +
                "   Lpu_aid," +
                "   HistologicMaterial_id," +
                "   BiopsyOrder_id," +
                "   EvnDirectionHistologic_IsPlaceSolFormalin)"+
                "values (" +
                "   :EvnDirection_id," +
                "   :EvnDirectionHistologic_id," +
                "   :EvnDirectionHistologic_IsUrgent," +
                "   :Lpu_aid," +
                "   :HistologicMaterial_id," +
                "   :BiopsyOrder_id," +
                "   :EvnDirectionHistologic_IsPlaceSolFormalin);", params);

    }

    public int getDiagID(String ds) {
        params = new MapSqlParameterSource();
        jdbcTemplate1 = new JdbcTemplate(setDataSource());
        DiagMapper diagMapper = new DiagMapper();
        params.addValue("diagcod",ds);
       int a =  jdbcTemplate1.query("SELECT * FROM Diag d  WHERE Diag_Code =\'"+ds+"\';", new DiagMapper()).get(0).getDiag_id();


       return a;
    }

    public Number getLpuSection_did(String lpuIn) {

        jdbcTemplate1 = new JdbcTemplate(setDataSource());
        System.out.println(lpuIn);

        List<LpuSection_did> a = jdbcTemplate1.query("SELECT b.LpuSection_id FROM LpuUnit a Join LpuSection b  on a.LpuUnit_id =b.LpuUnit_id WHERE LpuUnit_FRMOUnitID = \'"+lpuIn+"\';\n", new LpuSectionDidMapper());

        if(!a.isEmpty())
            return a.get(0).getLpuSection_id();
        return null;
    }

    public LpuSectionAndProfil getLpuSectionAndProfil(long lpuIn) {

        jdbcTemplate1 = new JdbcTemplate(setDataSource());

        List<LpuSectionAndProfil> a = jdbcTemplate1.query("     SELECT  ls.LpuSection_id , qw.LpuSectionProfile_id    FROM LpuSection ls JOIN LpuSectionProfile qw on ls.LpuSectionProfile_id  = qw.LpuSectionProfile_id WHERE qw.LpuSectionProfile_Name like 'патологической %' and ls.Server_id = "+lpuIn+";", new LpuAndProfilMapper());

        if(!a.isEmpty())
            return a.get(0);
        return null;
    }

    public long getMedstaf(int a) {
        jdbcTemplate1 = new JdbcTemplate(setDataSource());


        List<MedWorker> b = jdbcTemplate1.query("SELECT id FROM persis.MedWorker WHERE Person_id =\'"+a+"\';", new MedWorckerMapper());
        if(!b.isEmpty())
            return b.get(0).getId();
        return 0;

    }

    public Long getLpuSection_id(String lpuIn) {
        jdbcTemplate1 = new JdbcTemplate(setDataSource());
        String q = "SELECT b.LpuSection_id From LpuUnit a Join LpuSection b  on a.LpuUnit_id =b.LpuUnit_id WHERE LpuUnit_FRMOUnitID = \'"+lpuIn+"\';";

        System.out.println(q);
        List<LpuSection_did> b = jdbcTemplate1.query(q, new LpuSectionDidMapper());

        if(!b.isEmpty())
            return Long.valueOf(b.get(0).getLpuSection_id());
        return Long.valueOf(0);
    }

    public long getMedstafFact(long medPersonal_id) {
        jdbcTemplate1 = new JdbcTemplate(setDataSource());


//        List<MedWorker> b = jdbcTemplate1.query("SELECT MedStaffFact_id as id FROM MedStaffFactCache WHERE MedPersonal_id ="+medPersonal_id+";", new MedWorckerMapper());

        String query = "SELECT TOP 1 \n" +
                "\tms.MedStaffFact_id as id \n" +
                "FROM MedStaffFactCache ms \n" +
                "WHERE (WorkData_endDate <='2021-08-24' OR WorkData_endDate IS NULL) \n" +
                "AND MedStaffFact_Stavka >0 \n" +
                "AND ms.MedPersonal_id = "+medPersonal_id +";";
        List<MedWorker> b = jdbcTemplate1.query(query, new MedWorckerMapper());

        if(!b.isEmpty())
            return b.get(0).getId();
        return 0;
    }

    public long getLpuSection(long medPersonal_id) {
        jdbcTemplate1 = new JdbcTemplate(setDataSource());
        System.out.println(medPersonal_id);
        List<MedWorker> b =jdbcTemplate1.query("SELECT LpuSection_id as id FROM MedStaffFactCache WHERE MedPersonal_id ="+medPersonal_id+";", new MedWorckerMapper());

        if(!b.isEmpty())
            return b.get(0).getId();
        return 0;
    }
}
