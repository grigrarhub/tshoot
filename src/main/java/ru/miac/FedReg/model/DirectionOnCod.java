package ru.miac.FedReg.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
@Data
@Accessors(chain = true)
public class DirectionOnCod {
    String Comment;
    String Date_Direction;
    String Number;
    int Priority;
    String Pat_SS;
    String DOCT_SS;
    String Sender;
    String LpuIn;
    String DS;
    String DateReceipt;
    int rf_BioMID;
    int IsFailed;
    int IsFormalin ,IsPackageSaved;
    String Name;
    String DOCT_FIO;
    int rf_kl_ProfitTypeID;
    String Value;
}
