package com.kkb.b2c.gciantispider.service.impl;

import com.kkb.b2c.gciantispider.dao.INhSysmonitorSpiderdistinguishDao;
import com.kkb.b2c.gciantispider.model.NhSysmonitorSpiderdistinguish;
import com.kkb.b2c.gciantispider.pageUtil.SpiderVO;
import com.kkb.b2c.gciantispider.service.INhSysmonitorSpiderdistinguishService;
import com.kkb.b2c.gciantispider.util.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NhSysmonitorSpiderdistinguishServiceImpl implements INhSysmonitorSpiderdistinguishService {

    @Autowired
    INhSysmonitorSpiderdistinguishDao nhSysmonitorSpiderdistinguishDao;
    
    @Override
    public SpiderVO getSysmonitorSpiderdistinguish() {
        SpiderVO spiderVO = new SpiderVO();
        String date = DateFormatter.getSpecifiedDayBefore(DateFormatter.getCurrTime());
        String hql = "from NhSysmonitorSpiderdistinguish n where n.date =:date ";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", DateFormatter.strToDate(date));
        NhSysmonitorSpiderdistinguish nhSysmonitorSpiderdistinguish = nhSysmonitorSpiderdistinguishDao.get(hql, map);
        if (null != nhSysmonitorSpiderdistinguish) {
            spiderVO.setNumspider(nhSysmonitorSpiderdistinguish.getNumspider());
        }else{
            spiderVO.setNumspider(null);
        }
        String sql = "select sum(n.numspider) from nh_sysmonitor_spiderdistinguish n";
        Long sumspider = nhSysmonitorSpiderdistinguishDao.countBySql(sql);
        spiderVO.setSumspider(sumspider);
        
        return spiderVO;
    }

}
