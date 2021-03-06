package ru.miac.FedReg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ApiKay {
    @JsonProperty("error_code")
    int errorCode;
    @JsonProperty("sess_id")
    String sessId;
}
