package com.kkb.b2c.gciantispider.service;

import com.kkb.b2c.gciantispider.model.NhUserConversionRate;

import java.util.List;


public interface INhUserConversionRateService {

    /**
     * 通过日期查询国内外转化率
     * @param date
     * @return
     */
    List<NhUserConversionRate> queryByDate(String startDate, String userType);
}
