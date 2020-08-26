package com.kkb.b2c.gciantispider.service;

import com.kkb.b2c.gciantispider.model.NhRulemonitorAntioccupy;

import java.util.List;

public interface INhRulemonitorAntioccupyService {
    
    public List<NhRulemonitorAntioccupy> getNhRulemonitorAntioccupyByTimeAndType(String timeType, String ruleType);
}
