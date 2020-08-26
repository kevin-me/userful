package com.kkb.b2c.gciantispider.service;

import com.kkb.b2c.gciantispider.model.SystemFunctionInfo;

import java.util.List;

public interface ISystemFunctionInfoService {
    /**
     * 获取所有系统功能运行状态
     * @return
     */
    List<SystemFunctionInfo> getAllSystemFunctionInfo();
}
