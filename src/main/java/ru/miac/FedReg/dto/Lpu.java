package ru.miac.FedReg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Lpu {
    @JsonProperty("Lpu_id")
    private long lpuId;
}
