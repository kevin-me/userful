/**
 * 
 */
package com.kkb.b2c.gciantispider.service;

import com.kkb.b2c.gciantispider.model.NhIllegalOccFlightRank;

import java.math.BigInteger;
import java.util.List;


public interface INhIllegalOccFlightRankService {

	/**
	 * 获取爬虫非法占座排行
	 * @return
	 **/
	List<NhIllegalOccFlightRank> getNhIllegalOccFlightRank(int pages, int rows, String startTime, String endTime);

	/**
	 * 获取数据量
	 * @return
	 **/
    BigInteger getAllCount(String startTime, String endTime);
}
