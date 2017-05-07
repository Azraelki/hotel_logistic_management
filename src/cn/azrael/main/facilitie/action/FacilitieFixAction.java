package cn.azrael.main.facilitie.action;

import java.net.URLDecoder;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionContext;

import cn.azrael.main.core.action.BaseAction;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.facilitie.entity.Facilitie;
import cn.azrael.main.facilitie.entity.FacilitieFix;
import cn.azrael.main.facilitie.service.FacilitieFixService;
import cn.azrael.main.facilitie.service.FacilitieService;
import cn.azrael.main.user.entity.Employee;
import cn.azrael.main.user.service.EmployeeService;

public class FacilitieFixAction extends BaseAction{
	@Resource
	private FacilitieFixService facilitieFixService;
	@Resource
	private EmployeeService employeeService;
	@Resource
	private FacilitieService facilitieService;
	private FacilitieFix facilitieFix;
	private Facilitie facilitie;
	private Employee employee;
	private String message;
	/**
	 * 设施维护信息展示
	 */
	public String info(){
		QueryHelper queryHelper = new QueryHelper(FacilitieFix.class, "ff");
		try{
			System.out.println(pageNo);
			if(facilitieFix!=null){
				if(facilitieFix.getStatus()!=null && facilitieFix.getStatus()!=0){
					queryHelper.addCondition("ff.status=?", facilitieFix.getStatus());
				}
				if(StringUtils.isNotBlank(facilitie.getName())){
					facilitie.setName(URLDecoder.decode(facilitie.getName(), "utf-8"));
					queryHelper.addCondition("ff.facilitieId.name like ?", "%"+facilitie.getName()+"%");
				}
			}
			queryHelper.addOrderByProperty("ff.dateBegin", QueryHelper.ORDER_BY_DESC);
			pageResult = facilitieFixService.getPageResult(queryHelper, this.getPageNo(), this.getPageSize());
		}catch(Exception e){
			throw new RuntimeException();
		}
		return "info";
	}
	/**
	 * 添加页面
	 */
	public String add() throws Exception{
		//加载设施列表
		ActionContext.getContext().getContextMap().put("facilitieList", facilitieService.findByType(2));
		try {
			//判断传入信息不为空
			if(facilitieFix!=null){
				if(facilitie!=null && facilitie.getId().length() == 32){
					facilitieFix.setStatus(1);
					facilitieFix.setFacilitieId(facilitie);
					facilitieFixService.save(facilitieFix);
					message = "添加成功！";
				}else{
					message = "请选择设施种类！";
				}
			}
		} catch (Exception e) {
			message = "添加失败!";
			throw new RuntimeException();
		}
		return "add";
	}
	/**
	 * 编辑页面
	 */
	public String editUI(){
		if(facilitieFix!=null && facilitieFix.getId()!=null){
			facilitieFix = facilitieFixService.findObjectById(facilitieFix.getId());
		}
		return "editUI";
	}
	/**
	 * 编辑
	 */
	public String edit(){
		try {
			if(facilitieFix!=null && facilitieFix.getId()!=null){
				//当为已处理时添加日期
				if(facilitieFix.getStatus() == 3){
					facilitieFix.setDateEnd(new Date().getTime()/1000.0);
				}
				//当第一次传入姓名时查找并保存到facilitieFix
				if(employee!=null){
					if(StringUtils.isNotBlank(employee.getName())){
						employee.setName(URLDecoder.decode(employee.getName(), "utf-8"));
						employee = employeeService.findByName(employee.getName());
					}
					if(employee!=null){
						facilitieFix.setEmployeeId(employee);
					}
				}
				facilitieFixService.update(facilitieFix);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	/**
	 * 删除数据
	 */
	public String delete() throws Exception{
		try {
			if(facilitieFix!=null && facilitieFix.getId()!=null){
				facilitieFixService.delete(facilitieFix.getId());
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return "list";
	}
	/**
	 * 批量删除
	 */
	public String deleteSelected() throws Exception{
		if(selectedRow!=null){
			for(String s:selectedRow){
				try {
					facilitieFixService.delete(s);
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
			}
		}
		return "list";
	}
	public FacilitieFix getFacilitieFix() {
		return facilitieFix;
	}
	public void setFacilitieFix(FacilitieFix facilitieFix) {
		this.facilitieFix = facilitieFix;
	}
	public Facilitie getFacilitie() {
		return facilitie;
	}
	public void setFacilitie(Facilitie facilitie) {
		this.facilitie = facilitie;
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
	
}
