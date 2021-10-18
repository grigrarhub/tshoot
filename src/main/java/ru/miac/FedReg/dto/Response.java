package ru.miac.FedReg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import ru.miac.FedReg.dto.EvnData;

@Data
@Accessors(chain = true)
public class Response {
    @JsonProperty("error_code")
    String errorCode;
    @JsonProperty("error_msg")
    String errorMsg;
    @JsonProperty("data")
    EvnData data;

    @Override
    public String toString() {
        if(this.getErrorCode().equals("0")) {
            return "Response{" +
                    "error_code=" + errorCode +
                    ", data=" + data +
                    '}';
        }else
            return "Response{" +
                    "error_code=" + errorCode +
                    ",error_msg=" + errorMsg +
                    '}';
    }
}
