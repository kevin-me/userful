/*
 * Created on 2017年7月19日
 * NhStrategyServiceImpl.java V1.0
 *
 * Copyright Notice =========================================================
 * This file contains proprietary information of Kingpintcn Information Technology Co.,Ltd
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2012 =======================================================
 */
package com.kkb.b2c.gciantispider.service.impl;

import com.kkb.b2c.gciantispider.dao.INhStrategyDao;
import com.kkb.b2c.gciantispider.exception.ServiceException;
import com.kkb.b2c.gciantispider.model.NhStrategy;
import com.kkb.b2c.gciantispider.service.INhStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhStrategyServiceImpl implements INhStrategyService {
    
    @Autowired
    private INhStrategyDao nhStrategyDao;
    /**
     * 保存策略信息
     */
    public void savaNhStrategy(NhStrategy nhStrategy){
        try {
            nhStrategyDao.save(nhStrategy);
        }
        catch (RuntimeException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
