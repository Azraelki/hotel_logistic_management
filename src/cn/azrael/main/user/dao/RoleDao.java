package cn.azrael.main.user.dao;

import cn.azrael.main.core.dao.BaseDao;
import cn.azrael.main.user.entity.Role;

public interface RoleDao extends BaseDao<Role>{
	//通过类型查找
	public boolean findByType(int type);
	//通过类型删除
	public void deleteByType(int type);
}
