package com.qhit.produceReport.service.impl;

import com.qhit.baseFlow.dao.IBaseFlowDao;
import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.baseFlow.service.IBaseFlowService;
import com.qhit.baseFlow.service.impl.BaseFlowServiceImpl;
import com.qhit.energyConsume.pojo.EnergyConsume;
import com.qhit.energyConsume.service.IEnergyConsumeService;
import com.qhit.produceFault.pojo.ProduceFault;
import com.qhit.produceJob.pojo.ProduceJob;
import com.qhit.produceJob.service.IProduceJobService;
import com.qhit.produceReport.service.IProduceReportService;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.qhit.produceReport.dao.IProduceReportDao;
import com.qhit.produceReport.pojo.ProduceReport;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
* Created by GeneratorCode on 2019/04/10
*/

@Service 
public class ProduceReportServiceImpl  implements IProduceReportService{

    @Resource 
    IProduceReportDao dao;

    @Resource
    IBaseFlowService baseFlowService;

    @Resource
    IProduceJobService produceJobService;

    @Resource
    IEnergyConsumeService energyConsumeService;



    @Override 
    public boolean insert(Object object) { 
        return dao.insert(object); 
    } 

    @Override 
    public boolean update(Object object) { 
        return dao.update(object); 
    } 

    @Override 
    public boolean updateSelective(Object object) { 
        return dao.updateSelective(object); 
    } 

    @Override 
    public boolean delete(Object id) { 
        ProduceReport produceReport = findById(id); 
        return dao.delete(produceReport); 
    }

    @Override 
    public List findAll() {
        List<ProduceReport> list=dao.findAll();
        for (ProduceReport report: list){
            if (report.getStartjobtime()==null&&report.getCompletetime()==null){
                report.setStatus("未完成");
            }
            if(report.getStartjobtime()!=null&&report.getCompletetime()==null){
                report.setStatus("作业中");
            }
            if (report.getStartjobtime()!=null&&report.getCompletetime()!=null){
                report.setStatus("已完成");
            }
        }
        return list;
    } 

    @Override 
    public ProduceReport findById(Object id) { 
        List<ProduceReport> list = dao.findById(id); 
        return  list.get(0); 
    } 

    @Override 
    public List<ProduceReport> search(ProduceReport produceReport) { 
        return dao.search(produceReport); 
    }

    @Override
    public void completeTask(ProduceReport produceReport) {
        //更新报岗表
        dao.updateSelective(produceReport);
        //插入作业信息表
        try {
            double jobs = duration(produceReport.getCompletetime(), produceReport.getStartjobtime());//时长
            BaseFlow baseFlow = baseFlowService.findById(produceReport.getFlowid());//获取设备id
            ProduceReport produceReport1 = findById(produceReport.getReportid());//获取装载量
            //斗轮机
            ProduceJob produceJob=new ProduceJob();
            produceJob.setDevid(baseFlow.getDljid());//添加设备ID
            produceJob.setStarttime(produceReport.getStartjobtime());//添加开始时间
            produceJob.setCompletetime(produceReport.getCompletetime());//添加完成时间
            produceJob.setDuration(jobs);//添加时长
            produceJob.setAmount((double) (produceReport1.getCapacity()*2/5));//添加此设备的工作量
            produceJob.setReportid(produceReport.getReportid());//添加报岗id
            produceJobService.insert(produceJob);//向数据库表中插入数据
            //装船机
            ProduceJob produceJob1=new ProduceJob();
            produceJob1.setDevid(baseFlow.getZcjid());
            produceJob1.setStarttime(produceReport.getStartjobtime());
            produceJob1.setCompletetime(produceReport.getCompletetime());
            produceJob1.setDuration(jobs);
            produceJob1.setAmount((double) (produceReport1.getCapacity()*2/5));
            produceJob1.setReportid(produceReport.getReportid());
            produceJobService.insert(produceJob1);
            // 皮带机
            ProduceJob produceJob2=new ProduceJob();
            produceJob2.setDevid(baseFlow.getPdjid());
            produceJob2.setStarttime(produceReport.getStartjobtime());
            produceJob2.setCompletetime(produceReport.getCompletetime());
            produceJob2.setDuration(jobs);
            produceJob2.setAmount((double) (produceReport1.getCapacity()*1/5));
            produceJob2.setReportid(produceReport.getReportid());
            produceJobService.insert(produceJob2);

            //插入能耗信息表
            double Electric =Math.random() * 200 + 100;
            double Water = Math.random() * 10+ 1;
            double Oil = Math.random() * 40+ 10;
            DecimalFormat df = new DecimalFormat("#.00");//保留两位小数

            //斗轮机
            double numdljElectric=produceReport1.getCapacity()*2/5*Electric;
            double numdljWater=produceReport1.getCapacity()*2/5*Water;
            double numdljOil=produceReport1.getCapacity()*2/5*Oil;
            EnergyConsume energyConsume=new EnergyConsume();
            energyConsume.setDevid(baseFlow.getDljid());
            energyConsume.setElectric(Double.valueOf(df.format(numdljElectric )));
            energyConsume.setWater(Double.valueOf(df.format(numdljWater)));
            energyConsume.setOil(Double.valueOf(df.format(numdljOil)));
            energyConsume.setReportid(produceReport.getReportid());
            energyConsumeService.insert(energyConsume);

           //装船机
            EnergyConsume energyConsume1=new EnergyConsume();
            energyConsume1.setDevid(baseFlow.getZcjid());
            energyConsume1.setElectric(produceReport1.getCapacity()*2/5*Electric);
            energyConsume1.setWater(produceReport1.getCapacity()*2/5*Water);
            energyConsume1.setOil(produceReport1.getCapacity()*2/5*Oil);
            energyConsume1.setReportid(produceReport.getReportid());
            energyConsumeService.insert(energyConsume1);

            //皮带机
            EnergyConsume energyConsume2=new EnergyConsume();
            energyConsume2.setDevid(baseFlow.getPdjid());
            energyConsume2.setElectric(produceReport1.getCapacity()*1/5*Electric);
            energyConsume2.setWater(produceReport1.getCapacity()*1/5*Water);
            energyConsume2.setOil(produceReport1.getCapacity()*1/5*Oil);
            energyConsume2.setReportid(produceReport.getReportid());
            energyConsumeService.insert(energyConsume2);
        } catch (Exception e) {
        }


    }

    //计算时长t1>t2
    public double duration(String t1,String t2) throws Exception {
        //计算时长
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将结束时间转换成日期格式
        Date comp = df.parse(t1);
        //将开始时间转换成日期格式
        Date start = df.parse(t2);
        //计算时长
        long shi = comp.getTime() - start.getTime();
        double i = shi / 1000.0 / 3600;
        double is = Math.round(i * 100) / 100.0;
        return is;
    }
}