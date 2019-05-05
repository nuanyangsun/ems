package com.qhit.baseDevice.service;

import java.util.List;
import com.qhit.baseDevice.pojo.BaseDevice;
/**
* Created by GeneratorCode on 2019/04/09
*/
public interface IBaseDeviceService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    BaseDevice findById(Object id);

    List<BaseDevice> search(BaseDevice baseDevice);

    List<BaseDevice> findTypeCompid(BaseDevice baseDevice);

}