/**
 * 
 */
package com.kkb.b2c.gciantispider.service;

import com.kkb.b2c.gciantispider.model.NhCrawlerCurdayInfo;


public interface INhCrawlerCurdayInfoService {

	/**
	 * 获取爬虫识别情况
	 */
	public NhCrawlerCurdayInfo getNhCrawlerCurdayInfo();
	/*
	 * 获取前一天爬虫识别情况
	 */
	public NhCrawlerCurdayInfo getNhCrawlerCurdayInfoByDate();
}
