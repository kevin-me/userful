/**
 * 
 */
package com.kkb.b2c.gciantispider.service;

import com.kkb.b2c.gciantispider.model.Datacollect;

import java.util.List;


public interface IDataCollectService {

	/**
	 * 获取所有服务器
	 * @return
	 */
	public List<Datacollect> getDataCollect();
	
	/**
	 * 删除服务器
	 * 
	 */
	public void deleteServer(String id);
	
	/**
	 * 
	 * 修改服务器数据
	 *
	 */
	public void modifyData(String id, String newScript);
	
	/**
	 * 
	 * 获取单个服务器
	 * @return
	 */
	public Datacollect get(String id);
}
