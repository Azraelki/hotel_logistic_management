package cn.azrael.main.purchase.action;

import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionContext;

import cn.azrael.main.core.action.BaseAction;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.facilitie.entity.Facilitie;
import cn.azrael.main.facilitie.service.FacilitieService;
import cn.azrael.main.purchase.entity.FacilitieUse;
import cn.azrael.main.purchase.service.FacilitieUseService;

public class FacilitieUseAction extends BaseAction{
	@Resource
	private FacilitieService facilitieService;
	@Resource
	private FacilitieUseService facilitieUseService;
	private FacilitieUse facilitieUse;
	private Facilitie facilitie;
	private Double beginDate;
	private Double endDate;
	private String message;
	public String execute(){
		return "default";
	}
	/**
	 * 采购单列表信息
	 */
	public String info() throws Exception{
		QueryHelper queryHelper = new QueryHelper(FacilitieUse.class, "fu");
		try {
			System.out.println(pageNo);
			if(facilitie!=null){
				if(StringUtils.isNotBlank(facilitie.getName())){
					List<Facilitie> fl = facilitieService.findByName(facilitie.getName());
					if(fl.size()>0){
						for(Facilitie f:fl){
							queryHelper.addOrCondition("fu.facilitieId.id=?", f.getId());
						}
					}else{
						queryHelper.addCondition("1!=1");
					}
					facilitie.setName(URLDecoder.decode(facilitie.getName(), "utf-8"));
				}
			}
			if(beginDate != null){
				System.out.println(beginDate);
				queryHelper.addCondition("fu.date >= ?", beginDate);
			}
			if(endDate != null){
				System.out.println(endDate);
				queryHelper.addCondition("fu.date <= ?", endDate);
			}
			queryHelper.addOrderByProperty("fu.date", QueryHelper.ORDER_BY_DESC);
			pageResult = facilitieUseService.getPageResult(queryHelper, this.getPageNo(), this.getPageSize());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
		return "info";
	}
	/**
	 * 添加页面
	 */
	public String add() throws Exception{
		//加载设施种类列表
		ActionContext.getContext().getContextMap().put("facilitieList", facilitieService.findObjects());
		try {
			//判断传入信息不为空
			if(facilitieUse!=null && facilitieUse.getFacilitieId().getId()!=null){
				facilitieUseService.addAndEditFacilitie(facilitieUse);
				message = "提交成功";
			}
		} catch (Exception e) {
			message = "添加失败!";
			throw new RuntimeException(e.getMessage());
		}
		return "add";
	}
	/**
	 * 编辑页面
	 */
	public String editUI(){
		//加载设施种类列表
		ActionContext.getContext().getContextMap().put("facilitieList", facilitieService.findObjects());
		if(facilitieUse!=null && facilitieUse.getId()!=null){
			facilitieUse = facilitieUseService.findObjectById(facilitieUse.getId());
		}
		return "editUI";
	}
	/**
	 * 编辑
	 */
	public String edit()throws Exception{
		try {
			if(facilitieUse!=null && facilitieUse.getId()!=null){
				facilitieUseService.editAndEditFacilitie(facilitieUse);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return "list";
	}
	/**
	 * 删除
	 */
	public String delete() throws Exception{
		try {
			if(facilitieUse!=null && facilitieUse.getId()!=null){
				facilitieUseService.deleteAndEditFacilitie(facilitieUse);
			}
		} catch (Exception e) {
			message="删除失败！";
			throw new RuntimeException(e.getMessage());
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
					facilitieUse = facilitieUseService.findObjectById(s);
					facilitieUseService.deleteAndEditFacilitie(facilitieUse);
				} catch (Exception e) {
					message="删除失败！";
					throw new RuntimeException(e.getMessage());
				}
			}
		}
		return "list";
	}
	public FacilitieUse getFacilitieUse() {
		return facilitieUse;
	}
	public void setFacilitieUse(FacilitieUse facilitieUse) {
		this.facilitieUse = facilitieUse;
	}
	public Facilitie getFacilitie() {
		return facilitie;
	}
	public void setFacilitie(Facilitie facilitie) {
		this.facilitie = facilitie;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
