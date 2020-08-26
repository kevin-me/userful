/**
 * 
 */
package com.kkb.b2c.gciantispider.service;

import com.kkb.b2c.gciantispider.model.NhAgencyCustomerAnalysis;

import java.util.List;


public interface INhAgencyCustomerAnalysisService {
	
	/**
	 * 获取代购识别分析
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<NhAgencyCustomerAnalysis> getNhAgencyCustomerAnalysis(String startDate, String endDate);
}
