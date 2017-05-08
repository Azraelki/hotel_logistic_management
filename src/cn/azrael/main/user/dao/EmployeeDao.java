package cn.azrael.main.user.dao;

import cn.azrael.main.core.dao.BaseDao;
import cn.azrael.main.user.entity.Employee;

public interface EmployeeDao extends BaseDao<Employee>{
	//根据电话号码查询员工
	public Employee findByPhone(String phoneNum);
}
