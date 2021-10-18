package ru.miac.FedReg.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Columns {
    String key;
    String title;

    public Columns(String kay, String title) {
        this.key = kay;
        this.title= title;
    }
}
