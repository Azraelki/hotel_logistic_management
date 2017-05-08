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
	//添加员工是判断其职务增添相应的role
	public void addEmployeeAndSaveUser(Employee employee);
	//删除员工并删除其登陆功能
	public void deleteAndDeleteUser(String id);
	//更新并判断其是否有必要更改登陆的权限
	public void updateAndUpdateUser(Employee employee);
}
