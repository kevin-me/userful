/*
 * Created on 2017年6月21日
 * NhModelServiceImpl.java V1.0
 *
 * Copyright Notice =========================================================
 * This file contains proprietary information of Kingpintcn Information Technology Co.,Ltd
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2012 =======================================================
 */
package com.kkb.b2c.gciantispider.service.impl;

import com.kkb.b2c.gciantispider.dao.INhModelDao;
import com.kkb.b2c.gciantispider.exception.ServiceException;
import com.kkb.b2c.gciantispider.model.NhModel;
import com.kkb.b2c.gciantispider.service.INhModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhModelServiceImpl implements INhModelService {

    @Autowired
    private INhModelDao nhModelDao;
    
    /**
     * 保存模型信息
     */
    public void saveNhModel(NhModel nhModel){
           try {
               nhModelDao.save(nhModel);
        }
        catch (RuntimeException e) {
            throw new ServiceException(e.getMessage());
        }
    }
    /**
     * 修改模型信息
     */
    public void updateNhModel(NhModel nhModel){
        nhModelDao.update(nhModel);
    }
}
