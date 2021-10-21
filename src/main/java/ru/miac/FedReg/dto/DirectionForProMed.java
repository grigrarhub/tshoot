package ru.miac.FedReg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DirectionForProMed {
    @JsonProperty("Person_id")
    private long personId;//= 4289946;
    @JsonProperty("EvnDirection_Num")
    private String evnDirectionNum;//= "41010100-467991";
    @JsonProperty("EvnDirection_setDate")
    private String evnDirectionSetDate;//=2021-07-27;
    @JsonProperty("PayType_id")
    private int payTypeId;//=201;
    @JsonProperty("DirType_id")
    private int dirTypeId =7;
    @JsonProperty("Diag_id")
    private long diagId;//= 16994;
    @JsonProperty("EvnDirection_Descr")
    private String evnDirectionDescr;//=Обоснование;
    @JsonProperty("Lpu_sid")
    private long lpuSid;//= 13101027;
    @JsonProperty("LpuSection_id")
    private long lpuSectionId;//= 99560028031;
    @JsonProperty("MedPersonal_id")
    private long medPersonalId;//= 81216;
    @JsonProperty("MedStaffFact_id")
    private long medStaffFactId;//= 36928;
    @JsonProperty("Lpu_did")
    private long lpuDid;//=13100928;
    @JsonProperty("LpuSectionProfile_id")
    private long lpuSectionProfileId;//= 20000348;
    @JsonProperty("LpuUnitType_id")
    private int lpuUnitTypeId =15;//=15;
    @JsonProperty("PrescriptionType_id")
    private int prescriptionType_id =15;//=15; @JsonProperty("EvnDirectionHistologic_IsUrgent")
    private int evnDirectionHistologicIsUrgent;//=1;
    @JsonProperty("Lpu_aid")
    private long lpuAid;//= 13100928;
    @JsonProperty("MedPersonalFIO")
    private String medpersonalfio;//=ЧЕРНЕЦКАЯ АЛЕКСАНДРА ГЕННАДЬЕВНА;
    @JsonProperty("HistologicMaterial_id")
    private int histologicMaterialId;//=2;
    @JsonProperty("BiopsyOrder_id")
    private int biopsyOrderId;
    @JsonProperty("BiopsyDT")
    private String biopsyDT;//=2021-07-27 00:00:00;
    @JsonProperty("Evn_didDT")
    private String evnDidDT;//=2021-07-27 00:00:00;
    @JsonProperty("BiopsyReceive_id")
    private int biopsyReceiveId;//=9;
    @JsonProperty("IsPlaceSolFormalin")
    private int isPlaceSolFormalin;//= 1
    @JsonProperty("LpuSectionName ")
    private String lpuSectionName;//= 1




    public String getJson() {
        return "{" +
                "\"Person_id\":" + personId +
                ", \"EvnDirection_Num\"=\'" + evnDirectionNum + '\"' +
                ", \"EvnDirection_setDate\"=\'" + evnDirectionSetDate + '\"' +
                ", \"PayType_id\":" + payTypeId +
                ", \"DirType_id\":" + dirTypeId +
                ", \"Diag_id\":" + diagId +
                ", \"EvnDirection_Descr\"=\'" + evnDirectionDescr + '\"' +
                ", \"Lpu_sid\":" + lpuSid +
                ", \"LpuSection_id\":" + lpuSectionId +
                ", \"MedPersonal_id\"=\'" + medPersonalId + '\"' +
                ", \"MedStaffFact_id\"=\'" + medStaffFactId + '\"' +
                ", \"Lpu_did\":" + lpuDid +
                ", \"LpuSectionProfile_id\":" + lpuSectionProfileId +
                ", \"LpuUnitType_id\":" + lpuUnitTypeId +
                ", \"EvnDirectionHistologic_IsUrgent\":" + evnDirectionHistologicIsUrgent +
                ", \"Lpu_aid\":" + lpuAid +
                ", \"MedPersonalFIO\"=\'" + medpersonalfio + '\"' +
                ", \"HistologicMaterial_id\":" + histologicMaterialId +
                ", \"BiopsyOrder_id\":" + biopsyOrderId +
                ", \"BiopsyDT\"=\'" + biopsyDT + '\"' +
                ", \"Evn_didDT\"=\'" + evnDidDT + '\"' +
                ", \"BiopsyReceive_id\":" + biopsyReceiveId +
                ", \"IsPlaceSolFormalin\":" + isPlaceSolFormalin +
                '}';
    }
}
