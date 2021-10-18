package ru.miac.FedReg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LpuUnitById {
    @JsonProperty("LpuUnitType_id")
    int lpuUnitTypeid;
}
