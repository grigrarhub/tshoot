package ru.miac.FedReg.forApi;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Napravlenie {
    private Long Evn_pid;// (N, Н) – Идентификатор случая-родителя (движение в КВС, посещения в ТАП) (значение сущности dbo.Evn);
    private Long Person_id;// (N, О) – Человек (значение сущности dbo.Person);
    private Long EvnDirection_Num;// (N, О) – Номер направления;
    private String EvnDirection_setDate;// (D, О) – Дата направления;
    private Long PayType_id;//201 (N, Н) – Вид оплаты (значение справочника dbo.PayType);
    private Long DirType_id;//=7 (N, О) – Тип направления (значение справочника dbo.DirType);
    private Long Diag_id;// (N, О) – Диагноз (значение справочника dbo.Diag);
    private String EvnDirection_Descr;// (S, Н) – Обоснование;
    private Long Lpu_sid;// (N, О) – Направившее МО (значение справочника dbo.Lpu);
    private Long LpuSection_id;// (N, O) – Направившее отделение МО (значение сущности dbo.LpuSection);
    private Long MedPersonal_id;// (N, O) – Направивший врач (значение сущности persis.MedWorker);
    private Long MedStaffFact_id;// (N, O) – Место работы направившего врача (значение сущности dbo.MedStaffFact);
    private Long MedPersonal_zid;// (N, Н) – Заведующий направившего отделения (значение сущности persis.MedWorker);
    private Long Lpu_did;// (N, О) – МО, куда направили (значение справочника dbo.Lpu);
    private Long LpuSectionProfile_id;// (N, O) – Профиль, куда направили (значение справочника dbo.LpuSectionProfile) #PROMEDWEB-41861;
    private Long MedPersonal_did;// (N, Н) – Врач, к кому направили (значение сущности persis.MedWorker);
    private Long TimeTableGraf_id;// (N, H) – Идентификатор поликлинической бирки;
    private Long TimeTableStac_id;// (N, H) – Идентификатор стационарной бирки;
    private Long TimeTableMedService_id;// (N, H) – Идентификатор лабораторной бирки;
    private Long TimeTableResource_id;// (N, H) – Идентификатор диагностической бирки.
    private Long PrescriptionType_id;// (N, У) – Тип назначения (значение справочника dbo.PrescriptionType). Может принимать значение 11- лабораторная диагностика, 12 – инструментальная диагностика, 6 – манипуляции и процедуры, 13 – консультационная услуга, 14 – операционный блок. Обязательный параметр, если DirType_id = 10 (на исследование), 11 (В консультационный кабинет), 15 (на процедуры), 20 (в операционный блок).
    private Long EvnPrescr_IsCito;// (N, У) – Признак «Cito» (0 – Нет, 1 – Да). Обязательный параметр, если DirType_id = 10, 11, 15 или 20;
    private Long UslugaComplex_id;// (N, У) – Идентификатор услуги (значение справочника dbo.UslugaComplex). Обязательный параметр, если DirType_id = 10, 11, 15 или 20;
    private Long MedService_id;// (N, H) – Идентификатор службы.
    private Long Resource_id;// (N, H) – Идентификатор ресурса.#99827
    private Long LpuUnitType_id;// (N, О) - Условия оказания медицинской помощи (значение справочника dbo.LpuUnitType)
    private Long EvnDirectionHistologic_IsUrgent;//(N, О) - Срочность (dbo.EvnDirectionHistologic.EvnDirectionHistologic_IsUrgent,Справочник:  dbo.YesNo).
    private Long Lpu_aid;//(N, О) - В пат.-анатом. лаб-ю ЛПУ (dbo.EvnDirectionHistologic.Lpu_aid)
    private String LpuSectionName;//(T, Н) - Наименование отделения (dbo.EvnDirectionHistologic.EvnDirectionHistologic_LpuSectionName)
    private String MedPersonalFIO;//(T, Н) - ФИО направившего врача (dbo.EvnDirectionHistologic.EvnDirectionHistologic_MedPersonalFIO)
    private String MedPersonalPhoneNum;//(T, Н) - Номер телефона врача (dbo.EvnDirectionHistologic.EvnDirectionHistologic_MedPersonalPhoneNum)
    private Long PersonAmbulatCard_id;//(N, Н) - Идентификатор оригинала амбулаторной карты (dbo.EvnDirectionHistologic.PersonAmbulatCard_id)
    private Long PersonAmbulatCard_Num;//(N, Н) - Номер оригинала амбулаторной карты (dbo.EvnDirectionHistologic.PersonAmbulatCard_Num)
    private Long EvnPS_id;//(N, Н) -  идентификатор карты выбывшего из стационара (dbo.EvnDirectionHistologic.EvnPS_id)
    private Long PredOperTreat;//(N, Н) - Проведенное предоперационное лечение (dbo.EvnDirectionHistologic.EvnDirectionHistologic_PredOperTreat)
    private String ClinicalDiag;//(T, Н) - Клинический диагноз (dbo.EvnDirectionHistologic.EvnDirectionHistologic_ClinicalDiag)
    private String ClinicalData;//(T, Н) - Клинические данные (dbo.EvnDirectionHistologic.EvnDirectionHistologic_ClinicalData)
    private Long HistologicMaterial_id;//(N, О) - Вид материала (dbo.EvnDirectionHistologic.HistologicMaterial_id, Справочник dbo.HistologicMaterial)
    private Long BiopsyOrder_id;//(N, О) -Кратность биопсии (dbo.EvnDirectionHistologic.BiopsyOrder_id Справочник: dbo.BiopsyOrder)
    private String BiopsyDT;//(D, Н) - Дата первичной биопсии (dbo.EvnDirectionHistologic.EvnDirectionHistologic_BiopsyDT)
    private String BiopsyNum;//(Т, Н) - Номер первичной биопсии (dbo.EvnDirectionHistologic.EvnDirectionHistologic_BiopsyNum)
    private String Evn_didDT;//(D, О) - Дата и время операции (забора материала) (dbo.Evn.Evn_didDT)
    private Long Operation;//(N, Н) - Вид операции (dbo.EvnDirectionHistologic.EvnDirectionHistologic_Operation)
    private String SpecimenSaint;//(Т, Н) - Маркировка материала (dbo.EvnDirectionHistologic.EvnDirectionHistologic_SpecimenSaint)
    private Long ObjectCount;//(N, Н) - Число объектов (dbo.EvnDirectionHistologic.EvnDirectionHistologic_ObjectCount)
    private Long BiopsyReceive_id;//(N, Н) - Способ получения материала (dbo.EvnDirectionHistologic.BiopsyReceive_id Справочник: dbo.BiopsyReceive)
    private Long IsPlaceSolFormalin;//(N, Н) - Материал помещен в 10%-ный раствор нейтрального формалина (dbo.EvnDirectionHistologic.EvnDirectionHistologic_IsPlaceSolFormalin Справочник: dbo.YesNo)

}
