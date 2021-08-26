package ru.miac.FedReg.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EvnData {
    String EvnDirectionHistologic_id;// "500910026997963",
    String EvnDirection_id;// "500910026997963",
    String Evn_id;// "500910026997963",
    String EvnQueue_id;// null,
    String EvnPrescr_id;// null
}
