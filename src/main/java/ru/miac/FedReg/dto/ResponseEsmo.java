package ru.miac.FedReg.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.miac.FedReg.entity.Histologic;

import java.util.Arrays;
import java.util.List;

@Data
@Accessors(chain = true)
public class ResponseEsmo {
    List<Columns> columns = Arrays.asList(new Columns("dateRequest","Дата выполнения"),
            new Columns("dataCod","Данные из Поликлинки"),
            new Columns("dataProMed","Данные из Стационара"),
            new Columns("num","Номер направления"),
            new Columns("EvnDirectionHistologic_id","EvnDirectionHistologic_id"),
            new Columns("EvnDirection_id","EvnDirection_id"),
            new Columns("Evn_id","Evn_id"),
            new Columns("EvnQueue_id","EvnQueue_id"),
            new Columns("issend","статус"),
            new Columns("errormsg","errormsg"),
            new Columns("dateSend","dateSend"),
            new Columns("dateRun","dateRun"));
    List<Histologic> data;

}
