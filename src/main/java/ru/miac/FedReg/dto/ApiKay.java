package ru.miac.FedReg.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ApiKay {
    int error_code;
    String sess_id;
}
