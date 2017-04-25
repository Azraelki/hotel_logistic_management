package cn.azrael.main.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.user.dao.EmployeeDao;
import cn.azrael.main.user.entity.Employee;
import cn.azrael.main.user.service.EmployeeService;
@Service("employeeService")
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements EmployeeService{
	private EmployeeDao employeeDao;
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
}
