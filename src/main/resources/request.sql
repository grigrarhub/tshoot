SELECT
              lbr.Date_Direction,
              lbr.[Number],
              lbr.Priority,
              lbr.Pat_SS,
              lbr.Pat_Family ,
              lbr.Pat_Name ,
              lbr.Pat_Ot,
              lbr.Pat_W,
              CAST(lbr.Pat_Birthday AS DATE) as Pat_Birthday,
              lbr.DOCT_SS,
              lbr .AdditionalComment ,
              lbr.IsPreviousResearchPerformed,
              lbr .PreviousTreatment,
              lbr.rf_kl_ProfitTypeID,
              lbr.rf_kl_TipOMSID ,
              lbr.Pat_N_POL,
              lbr.DOCT_FIO,
              lbr.Comment,
              oms.DS ,
              lbr.Priority,
              info.Lic as Sender,
              inf.Lic as LpuIn,
              qqq.DateReceipt,
              qqq.rf_BioMID ,qqq.IsFailed , qqq.IsFormalin ,qqq.IsPackageSaved, qqq.rf_LaboratoryResearchGUID, lldt.Name,qqq.Value, od.OID
          FROM lbr_LaboratoryResearch lbr LEFT JOIN rpt_lpuInfo info ON lbr.rf_LPUSenderID = info.LPUID
              LEFT JOIN rpt_lpuInfo inf ON lbr.rf_LPUID = inf.LPUID
              LEFT JOIN Oms_mkb oms ON lbr.rf_MKBID = oms.MKBID
              LEFT JOIN (select
              lr2.DateReceipt,
              ls.rf_BioMID ,
              ls.IsFailed ,
              ls.IsFormalin ,
              ls.IsPackageSaved,
              lr2.rf_LaboratoryResearchGUID,
              lov.Value
              from lbr_Sample ls LEFT Join lbr_Research lr2 on ls.rf_ResearchID = lr2.ResearchID
              LEFT JOIN lbr_OptionValue lov on lov.rf_SampleID = ls.SampleID WHERE lov.rf_OptionID=2) as qqq on lbr.GUID = qqq.rf_LaboratoryResearchGUID
              LEFT JOIN lbr_LabDirectionType lldt on lbr.rf_LabDirectionTypeID = lldt.LabDirectionTypeID
              LEFT JOIN hlt_DocPRVD hdp on lbr.rf_DocPRVDID = hdp.DocPRVDID
              LeFT JOIN oms_Department od on hdp.rf_DepartmentID =od.DepartmentID
          WHERE lbr.DateCreate >'2021-09-07' and lbr.rf_LabDirectionTypeID=3;