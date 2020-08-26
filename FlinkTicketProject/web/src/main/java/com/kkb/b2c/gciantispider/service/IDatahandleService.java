/**
 * 
 */
package com.kkb.b2c.gciantispider.service;


import com.kkb.b2c.gciantispider.model.Analyzerule;


public interface IDatahandleService {
	
	/**
	 * 
	 * 获取数据处理
	 * @return
	 */
	public Analyzerule getAnalyzerule(String behaviorType, String flightType, String hql);
	
	/**
	 * 
	 * 保存或修改数据
	 */
	public void saveOrUpdateData(Analyzerule analyzerule);
	
}
