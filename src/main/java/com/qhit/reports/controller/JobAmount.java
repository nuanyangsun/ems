package com.qhit.reports.controller;

import com.qhit.baseDevtype.pojo.BaseDevtype;
import com.qhit.baseDevtype.service.IBaseDevtypeService;
import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.baseFlow.service.IBaseFlowService;
import com.qhit.reports.pojo.JobBin;
import com.qhit.reports.service.IJobService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 94292 on 2019/4/23.
 */
@RestController
@RequestMapping("/jobAmount")
public class JobAmount {
    @Resource
    IJobService jobService;
    @Resource
    IBaseDevtypeService baseDevtypeService;
    @Resource
    IBaseFlowService baseFlowService;
    //流程名
    @RequestMapping("/flowAmount")
    public Object flowAmount(String year){
        Map map2 = new HashMap();
        Map map = new HashMap();
        Map[] ro = new Map[12];
        int j = 0;
        for (int i = 1; i < 13; i++) {
            map2.put("year",year);
            map2.put("month",i);
            List li = jobService.flowAmount(map2);
            if (li.size()!=0){
                Map map1 = new HashMap();
                JobBin o = (JobBin) li.get(0);
                String[] split = o.getFname().split(",");
                for (int k = 0; k < split.length; k++) {
                    String[] split1 = split[k].split(":");
                    map1.put(split1[0],split1[1]);
                }
                ro[j++] = map1;
            }
        }
        Map[] rows = new Map[j];
        int f = 0;
        for (int i = 0; i <rows.length ; i++) {
            if (ro[i]!=null){
                rows[f++] = ro[i];
            }
        }
        List<BaseFlow> all = baseFlowService.findAll();
        String[] columns = new String[all.size()+1];
        columns[0]="月份";
        for (int i = 0; i < all.size(); i++) {
            columns[i+1]=all.get(i).getFlowname();
        }
        map.put("columns",columns);
        map.put("rows",rows);
        return map;
    }

    @RequestMapping("/devTypeAmount")
    public Object devtypeAmount(String year){
        Map map=new HashMap();
        Map  mappara=new HashMap();
        Map[]  mapR=new Map[12];
        int j=0;
        for (int i=1; i<13;i++){
            mappara.put("year",year);
            mappara.put("month",i);
            List list = jobService.devtypeAmount(mappara);
            if (list.size()!=0){
                Map mapS=new HashMap();
                JobBin o = (JobBin) list.get(0);
                String[] split1 = o.getFname().split(",");
                for(int k=0;k<split1.length;k++){
                    String[] split2 = split1[k].split(":");
                    mapS.put(split2[0],split2[1]);
                }
                mapR[j++]=mapS;
            }
        }

        Map[] row=new Map[j];
        int r=0;
        for (int i=0;i<mapR.length;i++){
            if (mapR[i]!=null){
                row[r++]=mapR[i];
            }
        }

        List<BaseDevtype> allSize = baseDevtypeService.findAll();
        String[] columns=new String[allSize.size()+1];
        columns[0]="月份";
        for (int i=1;i<allSize.size();i++){
            columns[i+1]= allSize.get(i).getTypename();
        }
        map.put("columns",columns);
        map.put("rows",row);
        return map;
    }



}
