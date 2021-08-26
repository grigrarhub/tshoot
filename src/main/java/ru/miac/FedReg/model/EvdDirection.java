package ru.miac.FedReg.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EvdDirection {
    private long EvnDirection_id;
    private int Lpu_did;
    private int EvnDirection_IsCito;
    private int Lpu_sid;//напр орг
    private long Evn_id;
    private int DirType_id;
    private int Diag_id;
    private Long LpuSection_id;
    private int MedPersonal_id;
    private long LpuSection_did;
    private int TimeTableGraf_id;
    private String EvnDirection_Num;
    private int PrehospDirect_id; //
    private int StudyTarget_id=2;
}
