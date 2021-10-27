package ru.miac.FedReg.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import ru.miac.FedReg.mapper.DirectionMapper;
import ru.miac.FedReg.entity.DirectionOnCod;
import ru.miac.FedReg.repository.CodRepository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


@Repository("codRepositoryImpl")
@RequiredArgsConstructor
public class CodRepositoryImpl implements CodRepository {
    @Value("${cod.datasource.url}")
    private  String url;
    @Value("${cod.datasource.username}")
    private  String username;
    @Value("${cod.datasource.password}")
    private  String password;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Value("${sql}")
    private String sql;
    @PostConstruct
    public void setDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<DirectionOnCod> getDirections() throws IOException {
        MapSqlParameterSource params = new MapSqlParameterSource("date", LocalDateTime.now().minusMinutes(10));//Time.now().minusMinutes(120)
        System.out.println(sql);
        return namedParameterJdbcTemplate.query(sql,params,new DirectionMapper());
    }


}
