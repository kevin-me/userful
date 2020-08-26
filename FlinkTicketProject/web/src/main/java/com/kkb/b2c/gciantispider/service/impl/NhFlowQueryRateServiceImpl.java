/**
 * 
 */
package com.kkb.b2c.gciantispider.service.impl;

import com.kkb.b2c.gciantispider.dao.INhFlowQueryRateDao;
import com.kkb.b2c.gciantispider.model.NhFlowQueryRate;
import com.kkb.b2c.gciantispider.service.INhFlowQueryRateService;
import com.kkb.b2c.gciantispider.util.Common;
import com.kkb.b2c.gciantispider.util.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class NhFlowQueryRateServiceImpl implements INhFlowQueryRateService {

	@Autowired
	private INhFlowQueryRateDao nhFlowQueryRateDao;
	
	@Override
	public List<NhFlowQueryRate> getFlowQueryRate(String startDate, String endDate) {
		
		String hql = "from NhFlowQueryRate nfqr where 1=1";
		Map<String,Object> params = new HashMap<String,Object>();
		if(!Common.isEmpty(startDate)){
            hql = hql + " AND nfqr.recordTime >=:startTime";
            params.put("startTime", DateFormatter.strToDate(startDate));
        }if(!Common.isEmpty(endDate)){
            hql = hql + " AND nfqr.recordTime <=:endTime";
            params.put("endTime", DateFormatter.strToDate(endDate));
        }
        hql = hql + " ORDER BY nfqr.recordTime asc";
		
		return nhFlowQueryRateDao.find(hql, params);
		
	}

}
