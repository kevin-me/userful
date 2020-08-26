/**
 * 
 */
package com.kkb.b2c.gciantispider.service;

import com.kkb.b2c.gciantispider.model.NhCrawlerQueryRoutesRank;

import java.util.List;


public interface INhCrawlerQueryRoutesRankService {
	
	/**
	 * 获取爬虫查询航线排行
	 * @return
	 *
	 **/
	
	public List<NhCrawlerQueryRoutesRank> getNhCrawlerQueryRoutesRank(String startTime, String endTime);

}
