package ru.miac.FedReg.repository.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import ru.miac.FedReg.repository.ProMedRepository;

import javax.annotation.PostConstruct;

@Repository
public class ProMedRepositoryImpl implements ProMedRepository {
    @Value("${ProMed.url}")
    private  String url;
    @Value("${ProMed.username}")
    private  String username;
    @Value("${ProMed.password}")
    private  String password;
    private JdbcTemplate JdbcTemplate;

    @PostConstruct
    public void setDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        JdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void updataLpu(long lpi_id, String num){
        String query = "UPDATE EvnDirection set LpuSection_did  = "+lpi_id+ " where EvnDirection_Num  = '"+num+"';";
        JdbcTemplate.execute(query);
    }

    @Override
    public void updataEvnDirectionHistologicClinicalData(String additionalComment, String num) {
        String query = "UPDATE EvnDirectionHistologic set EvnDirectionHistologic_ClinicalData  = '"+additionalComment+ "' where EvnDirection_id  = "+num+";";
        JdbcTemplate.execute(query);
    }

    @Override
    public void updataEvnDirectionHistologicPredOperTreat(String previousTreatment, String evnDirectionId) {
        String query = "UPDATE EvnDirectionHistologic set EvnDirectionHistologic_PredOperTreat  = '"+previousTreatment+ "' where EvnDirection_id  = "+evnDirectionId+";";
        JdbcTemplate.execute(query);
    }


}
