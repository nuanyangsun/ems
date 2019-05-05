package com.qhit.reports.dao;

import com.qhit.produceReport.pojo.ProduceReport;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/** 
* Created by GeneratorCode on 2019/04/10
*/

@Mapper  
public interface IJobDao {
    List flowAmount(Map map);
    List devtypeAmount(Map map);
    List  devAmount(Map map);
}