package cn.azrael.main.user.service;

import cn.azrael.main.core.service.BaseService;
import cn.azrael.main.user.entity.Employee;

public interface EmployeeService extends BaseService<Employee>{
	/**
	 * 通过姓名查找
	 * @param name 员工姓名
	 * @return 员工实体
	 */
	public Employee findByName(String name);
}
