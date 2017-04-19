package cn.azrael.main.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
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
}
