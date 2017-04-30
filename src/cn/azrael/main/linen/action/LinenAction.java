package cn.azrael.main.linen.action;

import java.net.URLDecoder;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import cn.azrael.main.core.action.BaseAction;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.facilitie.entity.Facilitie;
import cn.azrael.main.facilitie.service.FacilitieService;
import cn.azrael.main.linen.entity.Linen;
import cn.azrael.main.linen.entity.LinensInfo;
import cn.azrael.main.linen.service.LinenService;
import cn.azrael.main.linen.service.LinensInfoService;

public class LinenAction extends BaseAction{
	@Resource
	private LinenService linenService;
	@Resource
	private FacilitieService facilitieService;
	@Resource
	private LinensInfoService linensInfoService;
	private Linen linen;
	private Facilitie facilitie;
	private Double beginDate;
	private Double endDate;
	private String message;
	public String execute(){
		return "default";
	}
	/**
	 * 布草设施信息展示
	 */
	public String fInfo(){
		QueryHelper queryHelper = new QueryHelper(Facilitie.class, "f");
		try{
			System.out.println(pageNo);
			queryHelper.addCondition("f.type=?", 1);//根据布草的设施类型查询
			if(facilitie!=null){
				if(StringUtils.isNotBlank(facilitie.getName())){
					facilitie.setName(URLDecoder.decode(facilitie.getName(), "utf-8"));
					queryHelper.addCondition("f.name like ?", "%"+facilitie.getName()+"%");
				}
			}
			pageResult = facilitieService.getPageResult(queryHelper, this.getPageNo(), this.getPageSize());
		}catch(Exception e){
			throw new RuntimeException();
		}
		return "fInfo";
	}
	/**
	 * 展示布草收发列表信息
	 */
	public String info() throws Exception{
		QueryHelper queryHelper = new QueryHelper(Linen.class, "l");
		try {
			System.out.println(pageNo);
			if(linen!=null){
				/*if(StringUtils.isNotBlank(linensInfo.getName())){
					linensInfo.setName(URLDecoder.decode(linensInfo.getName(), "utf-8"));
					queryHelper.addCondition("e.name like ?", "%"+linensInfo.getName()+"%");
				}*/
			}
			if(beginDate != null){
				System.out.println(beginDate);
				queryHelper.addCondition("l.date >= ?", beginDate);
			}
			if(endDate != null){
				System.out.println(endDate);
				queryHelper.addCondition("l.date <= ?", endDate);
			}
			queryHelper.addOrderByProperty("l.date", QueryHelper.ORDER_BY_DESC);
			pageResult = linenService.getPageResult(queryHelper, this.getPageNo(), this.getPageSize());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return "info";
	}
	/**
	 * 清单详情
	 */
	public String detail() {
		System.out.println(pageNo);
		if(linen!=null && linen.getId()!=null){
			linen = linenService.findObjectById(linen.getId());
		}
		return "detail";
	}
	/**
	 * 添加员工
	 */
	public String add() throws Exception{
		if(linen!=null){
			try {
				/*if(linensInfoService.){
					message = "出现同名员工,请加以区分!";
					return "add";
				}
				linensInfoService.save(linensInfo);
				message = "添加成功！";*/
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
		if(linen!=null && linen.getId()!=null){
			linen = linenService.findObjectById(linen.getId());
		}
		return "editUI";
	}
	/**
	 * 编辑员工
	 */
	public String edit(){
		try {
			if(linen!=null){
				linenService.update(linen);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	/**
	 * 删除当前清单和清单中的数据
	 */
	public String delete() throws Exception{
		try {
			linenService.delete(linen.getId());
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
					linenService.delete(s);
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
			}
		}
		return "list";
	}
	public Linen getLinen() {
		return linen;
	}
	public void setLinen(Linen linen) {
		this.linen = linen;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	
}
