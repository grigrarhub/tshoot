package ru.miac.FedReg.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
@Data
@Accessors(chain = true)
public class DirectionOnCod {
    String comment;
    String dateDirection;
    String number;
    int priority;
    String patFamily;
    String patName;
    Date patBirthday;
    String patOt;
    int patW;
    String patSS;
    String patNPOL;
    String doctss;
    String sender;
    String lpuIn;
    String ds;
    String dateReceipt;
    int rfBioMID;
    int isFailed;
    int  isPackageSaved;
    String name;
    String doctFio;
    int rfKlProfitTypeID;
    String value;
    String oid;
    boolean isFormalin;
}
