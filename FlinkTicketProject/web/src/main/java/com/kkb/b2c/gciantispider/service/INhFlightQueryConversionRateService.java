package com.kkb.b2c.gciantispider.service;

import com.kkb.b2c.gciantispider.model.NhFlightQueryConversionRate;

import java.util.List;

public interface INhFlightQueryConversionRateService {
    
    /**
     * 通过日期查询国内外转化率
     * @param date
     * @return
     */
    List<NhFlightQueryConversionRate> queryByDate(String startDate, String querySpiderType);

}
