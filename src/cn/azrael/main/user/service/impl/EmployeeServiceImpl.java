package cn.azrael.main.user.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.rowset.serial.SerialException;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.exception.ServiceException;
import cn.azrael.main.core.log.DescripLog;
import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.user.dao.EmployeeDao;
import cn.azrael.main.user.dao.RoleDao;
import cn.azrael.main.user.dao.UserDao;
import cn.azrael.main.user.entity.Employee;
import cn.azrael.main.user.entity.User;
import cn.azrael.main.user.service.EmployeeService;
@Service("employeeService")
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements EmployeeService{
	private EmployeeDao employeeDao;
	private UserDao userDao;
	private RoleDao roleDao;
	@Resource
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Resource
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.setBaseDao(employeeDao);
		this.employeeDao = employeeDao;
	}
	@Override
	public Employee findByName(String name) {
		QueryHelper queryHelper = new QueryHelper(Employee.class, "e");
		queryHelper.addCondition("e.name = ?", name);
		List<Employee> el = this.employeeDao.findObjects(queryHelper);
		if(el.size()!=0)
			return el.get(0);
		else
			return null;
	}
	@DescripLog(desc="添加员工判断其职务增添相应的role")
	@Override
	public void addEmployeeAndSaveUser(Employee employee)throws ServiceException{
		int num = employee.getJobId().getId();
		employeeDao.save(employee);
		if(roleDao.findByType(num)){
			employee = findByName(employee.getName());
			User u = new User();
			u.setEmployeeId(employee);
			u.setType(num);
			u.setPassword("e10adc3949ba59abbe56e057f20f883e");
			userDao.save(u);
		}
	}
	@DescripLog(desc="删除员工并删除其登陆功能")
	@Override
	public void deleteAndDeleteUser(String id) throws ServiceException{
		Employee employee = employeeDao.findObjectById(id);
		int num = employee.getJobId().getId();
		if(roleDao.findByType(num)){
			User user = userDao.findByEmployeeId(employee.getId());
			if(user!=null)
				userDao.delete(user.getId());
		}
		employee.setStatus(false);
		employeeDao.update(employee);
	}
	@DescripLog(desc="更新并判断其是否有必要更改登陆的权限")
	@Override
	public void updateAndUpdateUser(Employee employee) throws ServiceException{
		int num = employee.getJobId().getId();
		employeeDao.update(employee);
		User u = userDao.findByEmployeeId(employee.getId());
		if(u!=null){
			if(num!=u.getType() && (roleDao.findByType(num))){
				u.setType(num);
				userDao.update(u);
			}else if(num!=u.getType()){
				userDao.delete(u.getId());
			}
		}else{
			if(roleDao.findByType(num)){
				u = new User();
				u.setEmployeeId(employee);
				u.setPassword("e10adc3949ba59abbe56e057f20f883e");
				u.setType(num);
				userDao.save(u);
			}
		}
		
	}
}
