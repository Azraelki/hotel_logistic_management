package cn.azrael.main.user.action;

import java.util.List;

import javax.annotation.Resource;





import org.apache.commons.lang3.StringUtils;

import cn.azrael.main.core.action.BaseAction;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.user.entity.Employee;
import cn.azrael.main.user.entity.EmployeeWork;
import cn.azrael.main.user.service.EmployeeService;
import cn.azrael.main.user.service.EmployeeWorkService;

public class WorkAction extends BaseAction{
	@Resource
	private EmployeeWorkService employeeWorkService;
	@Resource
	private EmployeeService employeeService;
	private List<EmployeeWork> employeeWorkList;
	private EmployeeWork employeeWork;
	private Employee employee;
	private String message;
	private Double beginDate;
	private Double endDate;
	/**
	 * 展示员工列表信息
	 */
	public String info() throws Exception{
		QueryHelper queryHelper = new QueryHelper(EmployeeWork.class, "ew");
		try {
			System.out.println(pageNo);
			if(employee!=null && StringUtils.isNotBlank(employee.getName())){
				Employee e = employeeService.findByName(employee.getName());
				System.out.println(e);
				if(e!=null){
					queryHelper.addCondition("ew.employeeId.id = ?", e.getId());
				}else{
					employee.setName(employee.getName()+"不存在");
				}
			}
			if(beginDate != null){
				System.out.println(beginDate);
				queryHelper.addCondition("ew.date >= ?", beginDate-1);
			}
			if(endDate != null){
				System.out.println(endDate);
				queryHelper.addCondition("ew.date <= ?", endDate);
			}
			queryHelper.addOrderByProperty("ew.date", QueryHelper.ORDER_BY_DESC);
			pageResult = employeeWorkService.getPageResult(queryHelper, this.getPageNo(), this.getPageSize());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return "info";
	}
	/**
	 * 添加员工
	 */
	public String add() throws Exception{
		if(employeeWork!=null){
			try {
				Employee e = employeeService.findByName(employeeWork.getEmployeeId().getName());
				if(e!=null){
					employeeWork.setEmployeeId(e);
					employeeWorkService.save(employeeWork);
					message = "添加成功！";
				}else{
					message = "员工不存在，请检查员工姓名是否书写正确！";
				}
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
		if(employeeWork!=null && employeeWork.getId()!=null){
			employeeWork = employeeWorkService.findObjectById(employeeWork.getId());
		}
		return "editUI";
	}
	/**
	 * 编辑员工
	 */
	public String edit(){
		try {
			if(employeeWork!=null){
				employeeWorkService.update(employeeWork);
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
			employeeWorkService.delete(employeeWork.getId());
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
					employeeWorkService.delete(s);
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
			}
		}
		return "list";
	}
	public List<EmployeeWork> getEmployeeWorkList() {
		return employeeWorkList;
	}
	public void setEmployeeWorkList(List<EmployeeWork> employeeWorkList) {
		this.employeeWorkList = employeeWorkList;
	}
	public EmployeeWork getEmployeeWork() {
		return employeeWork;
	}
	public void setEmployeeWork(EmployeeWork employeeWork) {
		this.employeeWork = employeeWork;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Double getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Double beginDate) {
		this.beginDate = beginDate;
	}
	public Double getEndDate() {
		return endDate;
	}
	public void setEndDate(Double endDate) {
		this.endDate = endDate;
	}
	
	
}
