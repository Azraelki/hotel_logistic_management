package cn.azrael.main.user.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;

import cn.azrael.main.core.dao.impl.BaseDaoImpl;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.user.dao.RoleDao;
import cn.azrael.main.user.entity.Role;

public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

	@Override
	public boolean findByType(int type) {
		QueryHelper queryHelper = new QueryHelper(Role.class, "r");
		queryHelper.addCondition("r.type=?", type);
		List<Role> role = findObjects(queryHelper);
		if(role!=null && role.size() > 0){
			return true;
		}
		return false;
	}

	@Override
	public void deleteByType(int type) {
		SQLQuery sql = getSession().createSQLQuery("DELETE FROM role where r_type=?");
		sql.setInteger(0, type);
		sql.executeUpdate();
	}
	
}
