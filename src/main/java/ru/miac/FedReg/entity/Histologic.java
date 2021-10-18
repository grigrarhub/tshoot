package ru.miac.FedReg.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Accessors(chain = true)
@Entity
@Transactional
public class Histologic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // вытаскивает id
    private Integer id;
    @Column
    String num;
    @Column(length=1000)
    String dataCod;
    @Column(length=1000)
    String dataProMed;
    @Column
    boolean issend = false;
    @Column(length=1000)
    String errormsg;
    @Column
    String errorcod;
    @Column
    LocalDateTime dateSend;
    @Column
    LocalDateTime dateRun;
    @Column
    Long evnDirectionHistologicId;
    @Column
    Long evnDirectionId;
    @Column
    Long evnId;
    @Column
    Long evnQueueId;
}
