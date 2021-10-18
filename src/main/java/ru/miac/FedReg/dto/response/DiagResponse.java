package ru.miac.FedReg.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import ru.miac.FedReg.dto.Diag;

import java.util.List;

@Data
@Accessors(chain = true)
public class DiagResponse {
    @JsonProperty("error_code")
    int errorCode;
    @JsonProperty("error_msg")
    String errorMsg;
    @JsonProperty("data")
    List<Diag> data;
}
