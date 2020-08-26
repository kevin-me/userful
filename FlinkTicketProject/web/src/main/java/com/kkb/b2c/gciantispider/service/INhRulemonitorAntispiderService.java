package com.kkb.b2c.gciantispider.service;

import com.kkb.b2c.gciantispider.model.NhRulemonitorAntispider;

import java.util.List;

public interface INhRulemonitorAntispiderService {

    public List<NhRulemonitorAntispider> getNhRulemonitorAntispiderByTimeAndType(String timeType, String ruleType);
}
