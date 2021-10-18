package ru.miac.FedReg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class PersonForProMed {
    @JsonProperty("Person_isUnknown")
    private String personIsUnknown;
    @JsonProperty("PersonSurName_SurName")
    private String personSurNameSurName;
    @JsonProperty("PersonFirName_FirName")
    private String personFirNameFirName;
    @JsonProperty("PersonSecName_SecName")
    private String personSecNameSecName;
    @JsonProperty("PersonBirthDay_BirthDay")
    private Date personBirthDayBirthDay;
    @JsonProperty("Person_Sex_id")
    private int personSexId;
    @JsonProperty("PersonPhone_Phone")
    private String personPhonePhone;
    @JsonProperty("PersonSnils_Snils")
    private String personSnilsSnils;
    @JsonProperty("SocStatus_id")
    private long socStatusId;
    @JsonProperty("UAddress_id")
    private String uAddressId;
    @JsonProperty("PAddress_id")
    private String pAddressId;
    @JsonProperty("BAddress_id")
    private String bAddressId;
    @JsonProperty("Org_id")
    private String orgId;
    @JsonProperty("Post_id")
    private String postId;
    @JsonProperty("PersonInn_Inn")
    private String personInnInn;
    @JsonProperty("LpuSectionName")
    private String lpuSectionName;
}
