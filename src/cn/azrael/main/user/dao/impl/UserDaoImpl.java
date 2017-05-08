package cn.azrael.main.user.dao.impl;

import java.util.List;

import cn.azrael.main.core.dao.impl.BaseDaoImpl;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.user.dao.UserDao;
import cn.azrael.main.user.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public User findByEmployeeId(String id) {
		QueryHelper queryHelper = new QueryHelper(User.class, "u");
		queryHelper.addCondition("u.employeeId.id=?", id);
		List<User> list = findObjects(queryHelper);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
