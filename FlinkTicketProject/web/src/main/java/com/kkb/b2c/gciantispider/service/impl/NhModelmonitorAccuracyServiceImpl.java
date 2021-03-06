package com.kkb.b2c.gciantispider.service.impl;

import com.kkb.b2c.gciantispider.dao.INhModelmonitorAccuracyDao;
import com.kkb.b2c.gciantispider.model.NhModelmonitorAccuracy;
import com.kkb.b2c.gciantispider.service.INhModelmonitorAccuracyService;
import com.kkb.b2c.gciantispider.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NhModelmonitorAccuracyServiceImpl implements INhModelmonitorAccuracyService {
    
    @Autowired
    INhModelmonitorAccuracyDao nhModelmonitorAccuracyDao;

    @Override
    public List<NhModelmonitorAccuracy> getNhModelmonitorAccuracyByType(String timeType, String flowType) {
        String hql = "from NhModelmonitorAccuracy r where r.timetype =:timetype";
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("timetype", Integer.valueOf(timeType));
        if(!Common.isEmpty(flowType)){
            hql = hql + " AND r.flowtype=:ruletype";
            params.put("ruletype", Integer.valueOf(flowType));
        }
        hql = hql + " order by r.date asc";
        return nhModelmonitorAccuracyDao.find(hql, params);
    }

}
