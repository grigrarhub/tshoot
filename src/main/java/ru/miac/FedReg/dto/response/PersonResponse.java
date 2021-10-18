package ru.miac.FedReg.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.miac.FedReg.dto.Person;
import ru.miac.FedReg.dto.PromedObject;

import java.util.List;

@Data
public class PersonResponse {
    int error_code;
    String error_msg;
    @JsonProperty("data")
    List<Person> data;
}
