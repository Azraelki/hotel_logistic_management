package cn.azrael.main.linen.action;

import java.util.List;

import javax.annotation.Resource;





import com.opensymphony.xwork2.ActionContext;

import cn.azrael.main.core.action.BaseAction;
import cn.azrael.main.facilitie.service.FacilitieService;
import cn.azrael.main.linen.entity.Linen;
import cn.azrael.main.linen.entity.LinensInfo;
import cn.azrael.main.linen.service.LinenService;
import cn.azrael.main.linen.service.LinensInfoService;
import cn.azrael.main.user.entity.Employee;

public class LinensInfoAction extends BaseAction{
	@Resource
	private LinensInfoService linensInfoService;
	@Resource
	private FacilitieService facilitieService;
	@Resource
	private LinenService linenService;
	private List<LinensInfo> linensInfoList;
	private Employee employee;
	private Linen linen;
	private LinensInfo linensInfo;
	private String message;
	public String execute(){
		return "default";
	}

	/**
	 * 编辑界面
	 */
	public String editUI(){
		System.out.println(pageNo);
		//加载布草种类列表
		ActionContext.getContext().getContextMap().put("facilitieList", facilitieService.findByType(1));
		if(linensInfo!=null && linensInfo.getId()!=null){
			linensInfo = linensInfoService.findObjectById(linensInfo.getId());
		}
		return "editUI";
	}
	/**
	 * 编辑
	 */
	public String edit(){
		System.out.println(pageNo);
		try {
			if(linensInfo!=null){
				linensInfoService.update(linensInfo);
				linen = linenService.findObjectById(linensInfo.getLinenId().getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	/**
	 * 删除单个记录
	 */
	public String delete() throws Exception{
		System.out.println(pageNo);
		try {
			if(linensInfo!=null){
				linensInfo = linensInfoService.findObjectById(linensInfo.getId());
				linen = linenService.findObjectById(linensInfo.getLinenId().getId());
				linensInfoService.delete(linensInfo.getId());
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return "list";
	}
	public List<LinensInfo> getLinensInfoList() {
		return linensInfoList;
	}
	public void setLinensInfoList(List<LinensInfo> linensInfoList) {
		this.linensInfoList = linensInfoList;
	}
	public LinensInfo getLinensInfo() {
		return linensInfo;
	}
	public void setLinensInfo(LinensInfo linensInfo) {
		this.linensInfo = linensInfo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Linen getLinen() {
		return linen;
	}
	public void setLinen(Linen linen) {
		this.linen = linen;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
