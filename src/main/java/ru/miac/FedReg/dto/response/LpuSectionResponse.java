package ru.miac.FedReg.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.miac.FedReg.dto.LpuSection;
import ru.miac.FedReg.dto.Person;

import java.util.List;

@Data
public class LpuSectionResponse {
    @JsonProperty("error_code")
    int errorCode;
    @JsonProperty("error_msg")
    String errorMsg;
    @JsonProperty("data")
    List<LpuSection> data;
}
