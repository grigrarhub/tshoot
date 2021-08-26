package ru.miac.FedReg.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EsmoInfo {
    private String uinoraction;
    private String pers_local_id;
    private String name;
    private String lastname;
    private String firstname;
    private String patronymic;
    private String birth_date;
    private String created_at;
    private String inform_system;
    private String error;
    private String data_path;
    private String original_error;
}




