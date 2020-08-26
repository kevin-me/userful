package com.kkb.b2c.gciantispider.service.impl;

import com.kkb.b2c.gciantispider.dao.IServerStatusInfoDao;
import com.kkb.b2c.gciantispider.model.ServerStatusInfo;
import com.kkb.b2c.gciantispider.service.IServerStatusInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServerStatusInfoServiceImpl implements IServerStatusInfoService {
    @Autowired
    private IServerStatusInfoDao serverStatusInfoDao;
    /**
     * 获取所有服务器状态
     */
    public List<ServerStatusInfo> getAllServerStatusInfo(){
        String hql = "From ServerStatusInfo order by name";
        return  serverStatusInfoDao.find(hql);
    }
	
    
	@Override
	public void dataBackups(List<ServerStatusInfo> serverStatusInfoList) {
		for(ServerStatusInfo serverStatusInfo : serverStatusInfoList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id", serverStatusInfo.getId());
			if(serverStatusInfoDao.get("From ServerStatusInfo where id = :id", map)==null){
				serverStatusInfoDao.save(serverStatusInfo);
			}
		}
	}
}
