package cn.azrael.main.user.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.core.util.QueryHelper;
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
	@Override
	public void deleteByType(int type) {
		roleDao.deleteByType(type);
	}
	@Override
	public Role findByTypeAndPrivilege(int type, String privilege) {
		QueryHelper queryHelper = new QueryHelper(Role.class, "r");
		queryHelper.addCondition("r.type=?", type);
		queryHelper.addCondition("r.privilege=?", privilege);
		List<Role> list = roleDao.findObjects(queryHelper);
		if(list!=null && list.size() > 0)
			return list.get(0);
		return null;
	}
	@Override
	public List<Role> findByType(int type) {
		QueryHelper queryHelper = new QueryHelper(Role.class, "r");
		queryHelper.addCondition("r.type=?", type);
		return roleDao.findObjects(queryHelper);
	}
}
