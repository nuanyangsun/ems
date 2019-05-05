package com.qhit.baseDevice.controller; 

import com.qhit.baseDevice.pojo.BaseDevice; 
import com.qhit.baseDevice.service.IBaseDeviceService;
import com.qhit.baseUser.pojo.BaseUser;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List; 
import org.springframework.web.bind.annotation.RestController; 

/** 
* Created by GeneratorCode on 2019/04/09
*/ 

@RestController 
@RequestMapping("/baseDevice") 
public class BaseDeviceController { 

    @Resource 
    IBaseDeviceService baseDeviceService; 

    @RequestMapping("/insert") 
    public void insert(BaseDevice baseDevice) { 
        baseDeviceService.insert(baseDevice); 
    } 

    @RequestMapping("/delete") 
    public void delete(Integer devid) { 
        baseDeviceService.delete(devid); 
    } 

    @RequestMapping("/update") 
    public void update(BaseDevice baseDevice) { 
        baseDeviceService.update(baseDevice); 
    } 

    @RequestMapping("/updateSelective") 
    public void updateSelective(BaseDevice baseDevice) { 
        baseDeviceService.updateSelective(baseDevice); 
    } 

    @RequestMapping("/load") 
    public BaseDevice load(Integer devid) { 
        BaseDevice baseDevice = baseDeviceService.findById(devid); 
        return baseDevice; 
    } 

    @RequestMapping("/list") 
    public List<BaseDevice> list()  { 
        List<BaseDevice> list = baseDeviceService.findAll(); 
        return list; 
    } 

    @RequestMapping("/search")
    public List<BaseDevice> search(BaseDevice baseDevice) {
        List<BaseDevice> list = baseDeviceService.search(baseDevice);
        return list;
    }

    @RequestMapping("/findDljByCompid")
    public List<BaseDevice> findDljByCompid(HttpSession session,BaseDevice baseDevice) {
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUser");
        baseDevice.setCompid(baseUser.getCompid());
        baseDevice.setTypeid(1);
        List<BaseDevice> dllist = baseDeviceService.findTypeCompid(baseDevice);
        return dllist;
    }
    @RequestMapping("/findCzjByCompid")
    public List<BaseDevice> findCzjByCompid(HttpSession session,BaseDevice baseDevice) {
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUser");
        baseDevice.setCompid(baseUser.getCompid());
        baseDevice.setTypeid(2);
        List<BaseDevice> zclist = baseDeviceService.findTypeCompid(baseDevice);
        return zclist;
    }
    @RequestMapping("/findPdjByCompid")
    public List<BaseDevice> findPdjByCompid(HttpSession session,BaseDevice baseDevice) {
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUser");
        baseDevice.setCompid(baseUser.getCompid());
        baseDevice.setTypeid(3);
        List<BaseDevice> pdlist = baseDeviceService.findTypeCompid(baseDevice);
        return pdlist;
    }
} 
