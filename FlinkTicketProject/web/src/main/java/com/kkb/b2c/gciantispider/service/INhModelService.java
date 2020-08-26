/*
 * Created on 2017年6月21日
 * INhModelService.java V1.0
 *
 * Copyright Notice =========================================================
 * This file contains proprietary information of Kingpintcn Information Technology Co.,Ltd
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2012 =======================================================
 */
package com.kkb.b2c.gciantispider.service;

import com.kkb.b2c.gciantispider.model.NhModel;

public interface INhModelService {

    void saveNhModel(NhModel nhModel);
    
    void updateNhModel(NhModel nhModel);
}
