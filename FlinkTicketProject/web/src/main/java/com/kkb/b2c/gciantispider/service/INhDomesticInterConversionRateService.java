package com.kkb.b2c.gciantispider.service;

import com.kkb.b2c.gciantispider.model.NhDomesticInterConversionRate;

import java.util.List;


public interface INhDomesticInterConversionRateService {
    /**
     * 通过日期查询国内外转化率
     * @param date
     * @return
     */
    List<NhDomesticInterConversionRate> queryByDate(String startDate, String flightType);
    
}
