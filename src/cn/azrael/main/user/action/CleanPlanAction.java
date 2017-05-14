package cn.azrael.main.user.action;


import javax.annotation.Resource;


import cn.azrael.main.core.action.BaseAction;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.user.entity.CleanPlan;
import cn.azrael.main.user.entity.Employee;
import cn.azrael.main.user.service.CleanPlanService;
import cn.azrael.main.user.service.EmployeeService;

public class CleanPlanAction extends BaseAction{
	@Resource
	private CleanPlanService cleanPlanService;
	@Resource
	private EmployeeService employeeService;
	private CleanPlan cleanPlan;
	private String message;
	private Double beginDate;
	private Double endDate;
	/**
	 * 展示员工列表信息
	 */
	public String info() throws Exception{
		QueryHelper queryHelper = new QueryHelper(CleanPlan.class, "cp");
		try {
			System.out.println(pageNo);
			if(beginDate != null){
				System.out.println(beginDate);
				queryHelper.addCondition("cp.begin >= ?", beginDate-1);
			}
			if(endDate != null){
				System.out.println(endDate);
				queryHelper.addCondition("cp.end <= ?", endDate);
			}
			queryHelper.addOrderByProperty("cp.begin", QueryHelper.ORDER_BY_DESC);
			pageResult = cleanPlanService.getPageResult(queryHelper, this.getPageNo(), this.getPageSize());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return "info";
	}
	/**
	 * 添加员工
	 */
	public String add() throws Exception{
		if(cleanPlan!=null){
			try {
				Employee e = employeeService.findByName(cleanPlan.getEmployeeId().getName());
				if(e!=null){
					cleanPlan.setEmployeeId(e);
					cleanPlanService.save(cleanPlan);
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
		if(cleanPlan!=null && cleanPlan.getId()!=null){
			cleanPlan = cleanPlanService.findObjectById(cleanPlan.getId());
		}
		return "editUI";
	}
	/**
	 * 编辑员工
	 */
	public String edit(){
		try {
			if(cleanPlan!=null){
				cleanPlanService.update(cleanPlan);
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
			cleanPlanService.delete(cleanPlan.getId());
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
					cleanPlanService.delete(s);
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
			}
		}
		return "list";
	}
	public CleanPlan getCleanPlan() {
		return cleanPlan;
	}
	public void setCleanPlan(CleanPlan cleanPlan) {
		this.cleanPlan = cleanPlan;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
