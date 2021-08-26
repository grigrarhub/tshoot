package ru.miac.FedReg.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Response {
       int error_code;
       String error_msg;
       EvnData data;

    @Override
    public String toString() {
        if(this.getError_code() == 0) {
            return "Response{" +
                    "error_code=" + error_code +
                    ", data=" + data +
                    '}';
        }else
            return "Response{" +
                    "error_code=" + error_code +
                    ",error_msg=" + error_msg +
                    '}';
    }
}
