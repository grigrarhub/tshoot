package ru.miac.FedReg.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Person {
    @JsonProperty("Person_id")
    int Person_id;
    @JsonProperty("PersonSnils_Snils")
    String PersonSnils_Snils;
    }
