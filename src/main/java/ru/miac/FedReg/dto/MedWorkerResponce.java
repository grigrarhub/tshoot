package ru.miac.FedReg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class MedWorkerResponce {
    @JsonProperty("error_code")
    int errorCode;
    @JsonProperty("error_msg")
    String errorMsg;
    @JsonProperty("data")
    PromedObject data;
}
