package ru.miac.FedReg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LpuSection {
    @JsonProperty("LpuSection_id")
    Long lpuSectionId;
    @JsonProperty("LpuUnitType_id")
    Integer lpuUnitTypeId;
    @JsonProperty("LpuSection_Name")
    String lpuSectionName;
}
