/*
 * Created on 2017年6月21日
 * INhRuleServiceImpl.java V1.0
 *
 * Copyright Notice =========================================================
 * This file contains proprietary information of Kingpintcn Information Technology Co.,Ltd
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2012 =======================================================
 */
package com.kkb.b2c.gciantispider.service;

import com.kkb.b2c.gciantispider.model.NhRule;

import java.util.List;

public interface INhRuleService {

    void saveNhRule(NhRule nhRule);
    
    List<NhRule> findNhRuleById(String id);
    
    void updateNhRule(NhRule nhRule);
}
