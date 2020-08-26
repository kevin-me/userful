/**
 * 
 */
package com.kkb.b2c.gciantispider.service;

import com.kkb.b2c.gciantispider.model.NhFourFlowNum;

import java.util.List;


public interface INhFourFlowNumService {
	
	public List<NhFourFlowNum> getNhFourFlowNum(String startDate, String endDate);

}
