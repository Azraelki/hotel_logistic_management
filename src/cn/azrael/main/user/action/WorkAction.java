package cn.azrael.main.user.action;

import java.util.List;

import javax.annotation.Resource;


import cn.azrael.main.core.action.BaseAction;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.user.entity.EmployeeWork;
import cn.azrael.main.user.service.EmployeeWorkService;

public class WorkAction extends BaseAction{
	@Resource
	private EmployeeWorkService employeeWorkService;
	private List<EmployeeWork> employeeWorkList;
	private EmployeeWork employeeWork;
	private String message;
	/**
	 * 展示员工列表信息
	 */
	public String info() throws Exception{
		QueryHelper queryHelper = new QueryHelper(EmployeeWork.class, "ew");
		try {
			System.out.println(pageNo);
			if(employeeWork!=null){
				//TODO
			}
			queryHelper.addOrderByProperty("ew.arrivedAt", QueryHelper.ORDER_BY_ASC);
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
				employeeWorkService.save(employeeWork);
			} catch (Exception e) {
				message = "添加失败";
				throw new Exception(e.getMessage());
			}
			message = "添加成功！";
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
	
	
}
