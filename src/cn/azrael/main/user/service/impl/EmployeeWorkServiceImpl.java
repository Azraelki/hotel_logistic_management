package cn.azrael.main.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.user.dao.EmployeeWorkDao;
import cn.azrael.main.user.entity.EmployeeWork;
import cn.azrael.main.user.service.EmployeeWorkService;
@Service("employeeWorkService")
public class EmployeeWorkServiceImpl extends BaseServiceImpl<EmployeeWork> implements EmployeeWorkService{
	private EmployeeWorkDao employeeWorkDao;
	@Resource
	public void setEmployeeWorkDao(EmployeeWorkDao employeeWorkDao) {
		this.setBaseDao(employeeWorkDao);
		this.employeeWorkDao = employeeWorkDao;
	}
}
