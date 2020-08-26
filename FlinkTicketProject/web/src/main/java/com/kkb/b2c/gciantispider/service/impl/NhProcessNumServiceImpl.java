package com.kkb.b2c.gciantispider.service.impl;

import com.kkb.b2c.gciantispider.dao.INhProcessNumDao;
import com.kkb.b2c.gciantispider.model.NhProcessNum;
import com.kkb.b2c.gciantispider.service.INhProcessNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NhProcessNumServiceImpl implements INhProcessNumService {
    @Autowired
    INhProcessNumDao nhProcessNumDao;
    
    @Override
    public List<NhProcessNum> getAllNhProcessNums() {
        String hql = "from NhProcessNum n order by n.processNum ";
        return nhProcessNumDao.find(hql);
    }

    @Override
    public void delNhProcessNum(NhProcessNum nhProcessNum) {
        nhProcessNumDao.delete(nhProcessNum);
    }

    @Override
    public void insertNhProcessNum(NhProcessNum nhProcessNum) {
        nhProcessNumDao.save(nhProcessNum);
    }

    @Override
    public void updateNhProcessNum(NhProcessNum nhProcessNum) {
        nhProcessNumDao.update(nhProcessNum);
    }

    @Override
    public NhProcessNum getNhProcessNum(String processId) {
        String hql = "from NhProcessNum n where n.processId =:processId";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("processId", processId);
        return nhProcessNumDao.get(hql, map);
    }


}
