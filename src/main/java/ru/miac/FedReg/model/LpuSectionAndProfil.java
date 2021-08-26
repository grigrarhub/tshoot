package ru.miac.FedReg.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LpuSectionAndProfil {
    long LpuSection_id;
    long LpuSectionProfile_id;
}
