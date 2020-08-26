/**
 * 
 */
package com.kkb.b2c.gciantispider.service;

import com.kkb.b2c.gciantispider.model.NhFlowInfo;

import java.util.List;



public interface INhFlowInfoService {
	
	/**
	 * 获取流量情况
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<NhFlowInfo> getNhFlowInfo(String startDate, String endDate);
}
