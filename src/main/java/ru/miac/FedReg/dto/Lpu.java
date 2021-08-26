package ru.miac.FedReg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Lpu {
    @JsonProperty("Lpu_id")
    private int lpuId;
    @JsonProperty("Lpu_Name")
    private String Lpu_Name;
    @JsonProperty("Lpu_f003mcod")
    private String Lpu_f003mcod;
    @JsonProperty("LPU_OID")
    private String LPU_OID;
}