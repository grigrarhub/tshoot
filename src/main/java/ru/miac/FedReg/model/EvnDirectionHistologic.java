package ru.miac.FedReg.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EvnDirectionHistologic {
    private long EvnDirectionHistologic_id;
    private long EvnDirection_id;
    private int EvnDirectionHistologic_IsUrgent;
    private int Lpu_aid;
    private int HistologicMaterial_id;
    private int BiopsyOrder_id;
    private int EvnDirectionHistologic_IsPlaceSolFormalin;
}
