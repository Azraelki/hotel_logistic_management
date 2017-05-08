package cn.azrael.main.user.dao;

import cn.azrael.main.core.dao.BaseDao;
import cn.azrael.main.user.entity.User;

public interface UserDao extends BaseDao<User>{
	//通过员工id查找user
	public User findByEmployeeId(String id);
}
