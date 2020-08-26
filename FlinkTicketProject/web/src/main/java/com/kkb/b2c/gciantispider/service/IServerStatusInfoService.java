package com.kkb.b2c.gciantispider.service;

import com.kkb.b2c.gciantispider.model.ServerStatusInfo;

import java.util.List;

public interface IServerStatusInfoService {
    /**
     * 获取所有服务器状态
     * @return
     */
    List<ServerStatusInfo> getAllServerStatusInfo();
    
    /**
     * 数据备份
     * 
     **/
    
    void dataBackups(List<ServerStatusInfo> serverStatusInfoList);
}
