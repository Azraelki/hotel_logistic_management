package cn.azrael.main.user.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.user.dao.RoleDao;
import cn.azrael.main.user.entity.Role;
import cn.azrael.main.user.service.RoleService;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{
	private RoleDao roleDao;
	@Resource
	public void setRoleDao(RoleDao roleDao) {
		setBaseDao(roleDao);
		this.roleDao = roleDao;
	}
}
