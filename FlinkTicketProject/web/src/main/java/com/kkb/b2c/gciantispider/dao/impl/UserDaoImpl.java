package com.kkb.b2c.gciantispider.dao.impl;

import com.kkb.b2c.gciantispider.dao.IUserDao;
import com.kkb.b2c.gciantispider.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

    @Override
    public List<User> queryUserInfo(String id) {
        List<User> users  = super.find(id);
        return users;
    }

}
