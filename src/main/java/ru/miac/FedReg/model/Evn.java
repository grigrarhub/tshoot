package ru.miac.FedReg.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class Evn {
    private long Evn_id;
    private int lpuId;
    private int Evn_rid, EvnClass_id=49,Server_id,PersonEvn_id;
    private Date Evn_setDT;//дата начала события
    private Date Evn_insDT;
    private Date Evn_updDT;
    private int Evn_Index=0;
    private int Evn_Count=0;
    private int Person_id;
    private int Evn_IndexMinusOne=-1;
}
