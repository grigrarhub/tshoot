package ru.miac.FedReg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MedWorker {
    @JsonProperty("MedWorker_id")
    Integer medWorker_id;
    Integer id;
    @JsonProperty("LpuSection_id")
    long lpuSection_id;
    @JsonProperty("Lpu_id")
    long lpu_id;
}
