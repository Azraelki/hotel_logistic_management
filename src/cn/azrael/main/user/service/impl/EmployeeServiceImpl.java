package cn.azrael.main.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.user.dao.EmployeeDao;
import cn.azrael.main.user.dao.UserDao;
import cn.azrael.main.user.entity.Employee;
import cn.azrael.main.user.entity.User;
import cn.azrael.main.user.service.EmployeeService;
@Service("employeeService")
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements EmployeeService{
	private EmployeeDao employeeDao;
	private UserDao userDao;
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
	@Override
	public void addEmployeeAndSaveUser(Employee employee) {
		int num = employee.getJobId().getId();
		employeeDao.save(employee);
		if(num == 1 || num == 2 || num == 5 || num == 6){
			employee = findByName(employee.getName());
			User u = new User();
			u.setEmployeeId(employee);
			u.setType(num);
			u.setPassword("123456");
			userDao.save(u);
		}
		
	}
	@Override
	public void deleteAndDeleteUser(String id) {
		Employee employee = employeeDao.findObjectById(id);
		int num = employee.getJobId().getId();
		if(num == 1 || num == 2 || num == 5 || num == 6){
			User user = userDao.findByEmployeeId(employee.getId());
			if(user!=null)
				userDao.delete(user.getId());
		}
		employeeDao.delete(employee.getId());
	}
	@Override
	public void updateAndUpdateUser(Employee employee) {
		int num = employee.getJobId().getId();
		employeeDao.update(employee);
		User u = userDao.findByEmployeeId(employee.getId());
		if(u!=null){
			if(num!=u.getType() && (num == 1 || num == 2 || num == 5 || num == 6)){
				u.setType(num);
				userDao.update(u);
			}else if(num!=u.getType()){
				userDao.delete(u.getId());
			}
		}else{
			if(num == 1 || num == 2 || num == 5 || num == 6){
				u = new User();
				u.setEmployeeId(employee);
				u.setPassword("123456");
				u.setType(num);
				userDao.save(u);
			}
		}
		
	}
}
