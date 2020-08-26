/**
 * 
 */
package com.kkb.b2c.gciantispider.service.impl;

import com.kkb.b2c.gciantispider.dao.IDataCollectDao;
import com.kkb.b2c.gciantispider.model.Datacollect;
import com.kkb.b2c.gciantispider.service.IDataCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataCollectServiceImpl implements IDataCollectService {

	@Autowired
	private IDataCollectDao dataCollectDao;

	
	@Override
	public List<Datacollect> getDataCollect() {
		String hql = "from Datacollect";
		return dataCollectDao.find(hql);
	}

	
	@Override
	public void deleteServer(String id) {
		Datacollect datacollect = new Datacollect(id);
		dataCollectDao.delete(datacollect);
	}

	
	@Override
	public void modifyData(String id, String newScript) {
		
		Datacollect datacollect = get(id);
//		datacollect.setScript(newScript);
		dataCollectDao.update(datacollect);
	}
	
	public Datacollect get(String id){
		String hql = "from Datacollect where id = :id";
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("id",id);
		return dataCollectDao.get(hql, params);
	}
}
