package ru.miac.FedReg.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PersonEvn {
    private  int Server_id;
    private  int PersonEvn_id;
    private  int Person_id;
    private  int PersonEvnClass_id;
}
