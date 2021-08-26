package ru.miac.FedReg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LpuSection_did {
    @JsonProperty("LpuSection_id")
    private long LpuSection_id;
}
