package cn.azrael.main.user.action;

import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionContext;

import cn.azrael.main.core.action.BaseAction;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.user.entity.Employee;
import cn.azrael.main.user.service.EmployeeService;
import cn.azrael.main.user.service.JobService;


public class EmployeeAction extends BaseAction{
	@Resource
	private EmployeeService employeeService;
	@Resource
	private JobService jobService;
	private List<Employee> employeeList;
	private Employee employee;
	private String message;
	public String execute(){
		return "default";
	}
	/**
	 * 展示员工列表信息
	 */
	public String info() throws Exception{
		QueryHelper queryHelper = new QueryHelper(Employee.class, "e");
		try {
			System.out.println(pageNo);
			if(employee!=null){
				if(StringUtils.isNotBlank(employee.getName())){
					employee.setName(URLDecoder.decode(employee.getName(), "utf-8"));
					queryHelper.addCondition("e.name like ?", "%"+employee.getName()+"%");
				}
			}
			queryHelper.addCondition("e.status=?", true);
			queryHelper.addOrderByProperty("e.arrivedAt", QueryHelper.ORDER_BY_ASC);
			pageResult = employeeService.getPageResult(queryHelper, this.getPageNo(), this.getPageSize());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return "info";
	}
	/**
	 * 添加员工
	 */
	public String add() throws Exception{
		//加载职务信息列表
		ActionContext.getContext().getContextMap().put("jobList", jobService.findObjects());
		if(employee!=null){
			try {
				if(employeeService.findByName(employee.getName())!=null){
					message = "出现同名员工,请加以区分!";
					return "add";
				}
				employee.setStatus(true);
				employeeService.addEmployeeAndSaveUser(employee);
				message = "添加成功！";
			} catch (Exception e) {
				message = "添加失败";
				throw new Exception(e.getMessage());
			}
		}
		return "add";
	}
	/**
	 * 编辑员工页面
	 */
	public String editUI(){
		//加载职务信息列表
		ActionContext.getContext().getContextMap().put("jobList", jobService.findObjects());
		if(employee!=null && employee.getId()!=null){
			employee = employeeService.findObjectById(employee.getId());
		}
		return "editUI";
	}
	/**
	 * 编辑员工
	 */
	public String edit(){
		try {
			if(employee!=null){
				employeeService.updateAndUpdateUser(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	/**
	 * 删除单个员工
	 */
	public String delete() throws Exception{
		try {
			employeeService.deleteAndDeleteUser(employee.getId());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return "list";
	}
	/**
	 * 批量删除员工
	 */
	public String deleteSelected() throws Exception{
		if(selectedRow!=null){
			for(String s:selectedRow){
				try {
					employeeService.deleteAndDeleteUser(s);
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
			}
		}
		return "list";
	}
	
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
