package ru.miac.FedReg.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DirectionForProMed {
    @JsonProperty("Person_id")
    private long Person_id;//= 4289946;
    @JsonProperty("EvnDirection_Num")
    private String EvnDirection_Num;//= "41010100-467991";
    @JsonProperty("EvnDirection_setDate")
    private String EvnDirection_setDate;//=2021-07-27;
    @JsonProperty("PayType_id")
    private int PayType_id;//=201;
    @JsonProperty("DirType_id")
    private int DirType_id=7;
    @JsonProperty("Diag_id")
    private int Diag_id;//= 16994;
    @JsonProperty("EvnDirection_Descr")
    private String EvnDirection_Descr;//=Обоснование;
    @JsonProperty("Lpu_sid")
    private long Lpu_sid;//= 13101027;
    @JsonProperty("LpuSection_id")
    private long LpuSection_id;//= 99560028031;
    @JsonProperty("MedPersonal_id")
    private long MedPersonal_id;//= 81216;
    @JsonProperty("MedStaffFact_id")
    private long MedStaffFact_id;//= 36928;
    @JsonProperty("Lpu_did")
    private long Lpu_did;//=13100928;
    @JsonProperty("LpuSectionProfile_id")
    private long LpuSectionProfile_id;//= 20000348;
    @JsonProperty("LpuUnitType_id")
    private int LpuUnitType_id=15;//=15;
    @JsonProperty("EvnDirectionHistologic_IsUrgent")
    private int EvnDirectionHistologic_IsUrgent;//=1;
    @JsonProperty("Lpu_aid")
    private long Lpu_aid;//= 13100928;
    @JsonProperty("MedPersonalFIO")
    private String MedPersonalFIO;//=ЧЕРНЕЦКАЯ АЛЕКСАНДРА ГЕННАДЬЕВНА;
    @JsonProperty("HistologicMaterial_id")
    private int HistologicMaterial_id;//=2;
    @JsonProperty("BiopsyOrder_id")
    private int BiopsyOrder_id= 1;
    @JsonProperty("BiopsyDT")
    private String BiopsyDT;//=2021-07-27 00:00:00;
    @JsonProperty("Evn_didDT")
    private String Evn_didDT;//=2021-07-27 00:00:00;
    @JsonProperty("BiopsyReceive_id")
    private int BiopsyReceive_id;//=9;
    @JsonProperty("IsPlaceSolFormalin")
    private int IsPlaceSolFormalin;//= 1
}
