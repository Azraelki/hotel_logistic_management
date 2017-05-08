package cn.azrael.main.user.dao.impl;

import java.util.List;

import cn.azrael.main.core.dao.impl.BaseDaoImpl;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.user.dao.EmployeeDao;
import cn.azrael.main.user.entity.Employee;

public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDao{

	@Override
	public Employee findByPhone(String phoneNum) {
		QueryHelper queryHelper = new QueryHelper(Employee.class, "e");
		queryHelper.addCondition("e.phoneNumber=?", phoneNum);
		List<Employee> list = findObjects(queryHelper);
		if(list!=null && list.size()>0){
			return list.get(0);
		}else
			return null;
	}

}
