package ru.miac.FedReg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EvnData {
    @JsonProperty("EvnDirectionHistologic_id")
    String evnDirectionHistologicId;// "500910026997963",
    @JsonProperty("EvnDirection_id")
    String evnDirectionId;// "500910026997963",
    @JsonProperty("Evn_id")
    String evnId;// "500910026997963",
    @JsonProperty("EvnQueue_id")
    String evnQueueId;// null,
    @JsonProperty("EvnPrescr_id")
    String evnPrescrId;// null
}
