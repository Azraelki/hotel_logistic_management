package cn.azrael.main.user.action;

import java.util.List;

import javax.annotation.Resource;

import cn.azrael.main.core.action.BaseAction;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.user.entity.Employee;
import cn.azrael.main.user.service.EmployeeService;


public class EmployeeAction extends BaseAction{
	@Resource
	private EmployeeService employeeService;
	private List<Employee> employeeList;
	
	public String execute(){
		return "default";
	}
	public String info() throws Exception{
		QueryHelper queryHelper = new QueryHelper(Employee.class, "e");
		try {
			System.out.println(pageNo);
			pageResult = employeeService.getPageResult(queryHelper, pageNo, this.getPageSize());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return "info";
	}
	public String add(){
		return "add";
	}
	public String update(){
		return "update";
	}
	public String delete() throws Exception{
		return info();
	}
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
}
