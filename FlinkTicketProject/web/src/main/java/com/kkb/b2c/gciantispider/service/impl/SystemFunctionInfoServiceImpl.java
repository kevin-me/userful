package com.kkb.b2c.gciantispider.service.impl;

import com.kkb.b2c.gciantispider.dao.ISystemFunctionInfoDao;
import com.kkb.b2c.gciantispider.model.SystemFunctionInfo;
import com.kkb.b2c.gciantispider.service.ISystemFunctionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemFunctionInfoServiceImpl implements ISystemFunctionInfoService {
    @Autowired
    private ISystemFunctionInfoDao systemFunctionInfoDao;
    
    /**
     * 获取所有系统功能运行状态
     * @return List<SystemFunctionInfo>
     */
    public List<SystemFunctionInfo> getAllSystemFunctionInfo(){
        String hql = "From SystemFunctionInfo order by modelName";
        return systemFunctionInfoDao.find(hql);
    }
}
