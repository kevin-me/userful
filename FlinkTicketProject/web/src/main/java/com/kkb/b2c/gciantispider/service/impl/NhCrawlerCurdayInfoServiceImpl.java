package com.kkb.b2c.gciantispider.service.impl;

import com.kkb.b2c.gciantispider.dao.INhCrawlerCurdayInfoDao;
import com.kkb.b2c.gciantispider.model.NhCrawlerCurdayInfo;
import com.kkb.b2c.gciantispider.service.INhCrawlerCurdayInfoService;
import com.kkb.b2c.gciantispider.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class NhCrawlerCurdayInfoServiceImpl implements INhCrawlerCurdayInfoService {

	@Autowired
	private INhCrawlerCurdayInfoDao nhCrawlerCurdayInfoDao;
	
	@Override
	public NhCrawlerCurdayInfo getNhCrawlerCurdayInfo() {
		String hql = "from NhCrawlerCurdayInfo";
		return nhCrawlerCurdayInfoDao.get(hql);
	}
	/**
	 * 查询前一天的爬虫情况
	 */
	public NhCrawlerCurdayInfo getNhCrawlerCurdayInfoByDate(){
	    Map<String, Object> params = new HashMap<String, Object>();
	    //获取前一天时间
        String lastDay = TimeUtil.getLastDay();
	    //String lastDay = "2017-09-14";
	    String hql = "From NhCrawlerCurdayInfo cci WHERE DATE_FORMAT(cci.identifyTime,'%Y-%m-%d')=:lastDay";
	    params.put("lastDay", lastDay);
	    return nhCrawlerCurdayInfoDao.get(hql, params);
	}
}
