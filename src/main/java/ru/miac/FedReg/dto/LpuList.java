package ru.miac.FedReg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
@Data
@Accessors(chain = true)
public class LpuList {
    @JsonProperty("error_code")
    int error_code;
    @JsonProperty("data")
    List<Lpu> data;
}
