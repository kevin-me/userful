package com.kkb.b2c.gciantispider.dao.impl;

import com.kkb.b2c.gciantispider.dao.ISystemRoleDao;
import com.kkb.b2c.gciantispider.model.SystemRole;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SystemRoleDaoImpl extends BaseDaoImpl<SystemRole> implements ISystemRoleDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<String> getRoleByUser(String id) {
        String hql = "select distinct s.id from SystemRole s left join s.refUserRoles ur left join ur.account a where a.id =?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setString(0, id);
        List<String> list = query.list(); 
        return list;
    }

}
