package ru.miac.FedReg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LpuSectionAndProfil {
    @JsonProperty("LpuSection_id")
    long lpuSectionId;
}
