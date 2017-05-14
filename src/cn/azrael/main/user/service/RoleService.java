package cn.azrael.main.user.service;


import java.util.List;

import cn.azrael.main.core.service.BaseService;
import cn.azrael.main.user.entity.Role;

public interface RoleService extends BaseService<Role>{
	//根据type删除权限
	public void deleteByType(int type);
	//根据type查找集合
	public List<Role> findByType(int type);
	//根据type和权限查找
	public Role findByTypeAndPrivilege(int type,String privilege);
}
