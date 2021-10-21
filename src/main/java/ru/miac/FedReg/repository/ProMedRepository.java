package ru.miac.FedReg.repository;

public interface ProMedRepository {
    void updataLpu(long lpi_id, String num);
    void updataEvnDirectionHistologicClinicalData(String additionalComment, String num);
    void updataEvnDirectionHistologicPredOperTreat(String previousTreatment, String evnDirectionId);
}
