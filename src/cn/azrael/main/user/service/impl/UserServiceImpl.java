package cn.azrael.main.user.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.core.util.ExcelUtil;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.linen.entity.Linen;
import cn.azrael.main.user.dao.EmployeeDao;
import cn.azrael.main.user.dao.RoleDao;
import cn.azrael.main.user.dao.UserDao;
import cn.azrael.main.user.entity.Employee;
import cn.azrael.main.user.entity.Role;
import cn.azrael.main.user.entity.User;
import cn.azrael.main.user.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	private UserDao userDao;
	private RoleDao roleDao;
	private EmployeeDao employeeDao;
	@Resource
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	@Resource
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		setBaseDao(userDao);
		this.userDao = userDao;
	}
	@Override
	public List<Role> findRoleByUser(User user) {
		user = userDao.findObjectById(user.getId());
		QueryHelper queryHelper = new QueryHelper(Role.class, "r");
		queryHelper.addCondition("r.type=?", user.getType());
		return roleDao.findObjects(queryHelper);
	}
	@Override
	public User findByPhoneAndPassword(String phone, String password) {
		Employee e = employeeDao.findByPhone(phone);
		if(e == null)
			return null;
		QueryHelper queryHelper = new QueryHelper(User.class, "u");
		queryHelper.addCondition("u.employeeId.id=?", e.getId());
		queryHelper.addCondition("u.password=?", password);
		List<User> list = userDao.findObjects(queryHelper);
		if(list!=null && list.size()>0){
			return list.get(0);
		}else
			return null;
	}
}
