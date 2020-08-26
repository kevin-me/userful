package com.kkb.b2c.gciantispider.service.impl;

import com.kkb.b2c.gciantispider.dao.ISystemDataAnalysisDao;
import com.kkb.b2c.gciantispider.pageUtil.JsonVO;
import com.kkb.b2c.gciantispider.service.ISystemDataAnalysisService;
import com.kkb.b2c.gciantispider.util.TrafficUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SystemDataAnalysisServiceImpl implements ISystemDataAnalysisService {
    @Autowired
    private ISystemDataAnalysisDao systemDataAnalysisDao;
    /**
     * 获取所有系统分析数据速度
     */
    public JsonVO getAllSystemDataAnalysis(){
        List<JsonVO> jsonVOs = TrafficUtil.trafficInfo("DP");
        Collections.sort(jsonVOs);
        JsonVO jsonVO = new JsonVO();
        if(jsonVOs!=null && jsonVOs.size()!=0){
            jsonVO = jsonVOs.get(jsonVOs.size()-1);
        }
        return jsonVO;
    }
}
