package ru.miac.FedReg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PromedObject {

    @JsonProperty("Lpu_Name")
    private String lpuName;
    @JsonProperty("Lpu_f003mcod")
    private String lpuF003Mcod;
    @JsonProperty("LPU_OID")
    private String lpuOid;
    @JsonProperty("LpuSection_id")
    private long lpuSectionId;
    @JsonProperty("Lpu_id")
    private String lpuId;
    @JsonProperty("LpuSectionProfile_id")
    private String lpuSectionProfileId;
    @JsonProperty("LpuUnitType_id")
    private int lpuUnitTypeId;
    @JsonProperty("Post_id")
    private String postId;
    @JsonProperty("MedPersonal_id")
    private long medPersonalId;
    @JsonProperty("MedWorker_id")
    private long medWorkerId;
    @JsonProperty("MedStaffFact_id")
    private String medStaffFactId;
    @JsonProperty("WorkData_endDate")
    private String workDataEndDate;
    @JsonProperty("PersonSurName_SurName")
    private String personSurNameSurName;
    @JsonProperty("PersonFirName_FirName")
    private String personFirNameFirName;
    @JsonProperty("PersonSecName_SecName")
    private String personSecNameSecName;
    @JsonProperty("id")
    private long id;
}
