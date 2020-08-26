/**
 * 
 */
package com.kkb.b2c.gciantispider.service;

import com.kkb.b2c.gciantispider.model.NhFlowQueryRate;

import java.util.List;


public interface INhFlowQueryRateService {

	
	/**
	 * 获取查定比
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<NhFlowQueryRate> getFlowQueryRate(String startDate, String endDate);
	
}
