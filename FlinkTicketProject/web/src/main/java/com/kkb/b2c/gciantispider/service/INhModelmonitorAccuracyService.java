package com.kkb.b2c.gciantispider.service;

import com.kkb.b2c.gciantispider.model.NhModelmonitorAccuracy;

import java.util.List;

public interface INhModelmonitorAccuracyService {
    
    public List<NhModelmonitorAccuracy> getNhModelmonitorAccuracyByType(String timeType, String flowType);
}
