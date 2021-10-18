package ru.miac.FedReg.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.miac.FedReg.dto.LpuUnitById;
import ru.miac.FedReg.dto.MedWorker;

import java.util.List;

@Data
public class LpuUnitByIdResponce {
    @JsonProperty("error_code")
    int errorCode;
    @JsonProperty("error_msg")
    String errorMsg;
    @JsonProperty("data")
    List<LpuUnitById> data;
}
