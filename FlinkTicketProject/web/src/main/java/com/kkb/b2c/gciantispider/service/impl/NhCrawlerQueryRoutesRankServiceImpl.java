/**
 * 
 */
package com.kkb.b2c.gciantispider.service.impl;

import com.kkb.b2c.gciantispider.dao.INhCrawlerQueryRoutesRankDao;
import com.kkb.b2c.gciantispider.model.NhCrawlerQueryRoutesRank;
import com.kkb.b2c.gciantispider.service.INhCrawlerQueryRoutesRankService;
import com.kkb.b2c.gciantispider.util.Common;
import com.kkb.b2c.gciantispider.util.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class NhCrawlerQueryRoutesRankServiceImpl implements
        INhCrawlerQueryRoutesRankService {
	
	
	@Autowired
	private INhCrawlerQueryRoutesRankDao nhCrawlerQueryRoutesRankDao;

	
	@Override
	public List<NhCrawlerQueryRoutesRank> getNhCrawlerQueryRoutesRank(String startTime, String endTime) {
		Map<String, Object> params = new HashMap<String, Object>();
        String hql = "From NhCrawlerQueryRoutesRank f WHERE 1=1";
        if(!Common.isEmpty(startTime)){
            hql = hql + " AND f.recordTime >=:startTime";
            params.put("startTime", DateFormatter.strToDate(startTime));
        }
        if(!Common.isEmpty(endTime)){
            hql = hql + " AND f.recordTime <=:endTime";
            params.put("endTime", DateFormatter.strToDate(endTime));
        }
        hql = hql + " ORDER BY f.grapFrequency desc";
		return nhCrawlerQueryRoutesRankDao.find(hql, params);
	}

}
