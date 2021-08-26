package ru.miac.FedReg.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.miac.FedReg.model.PersonEvn;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class PersonEvnMapper implements RowMapper<PersonEvn> {
    @Override
    public PersonEvn mapRow(ResultSet resultSet, int i) throws SQLException {
        return new PersonEvn().setPerson_id(resultSet.getInt("Person_id"))
                .setServer_id(resultSet.getInt("Server_id"))
                .setPersonEvnClass_id(resultSet.getInt("PersonEvnClass_id"))
                .setPersonEvn_id(resultSet.getInt("PersonEvn_id")) ;
    }
}
