package com.qhit.reports.service.impl;

import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.baseFlow.service.IBaseFlowService;
import com.qhit.energyConsume.pojo.EnergyConsume;
import com.qhit.energyConsume.service.IEnergyConsumeService;
import com.qhit.produceJob.pojo.ProduceJob;
import com.qhit.produceJob.service.IProduceJobService;
import com.qhit.produceReport.dao.IProduceReportDao;
import com.qhit.produceReport.pojo.ProduceReport;
import com.qhit.produceReport.service.IProduceReportService;
import com.qhit.reports.dao.IJobDao;
import com.qhit.reports.service.IJobService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by GeneratorCode on 2019/04/10
*/

@Service 
public class JobServiceImpl implements IJobService {

    @Resource 
    IJobDao dao;

    @Override
    public List flowAmount(Map map) {
        List list = dao.flowAmount(map);
        return list;
    }

    @Override
    public List devtypeAmount(Map map) {
        List list = dao.devtypeAmount(map);
        return list;
    }

    @Override
    public List devAmount(Map map) {
        List list = dao.devAmount(map);
        return list;
    }


}