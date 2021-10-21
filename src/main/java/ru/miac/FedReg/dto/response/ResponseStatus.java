package ru.miac.FedReg.dto.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseStatus {
    String status;
    String last_log_record;
}
