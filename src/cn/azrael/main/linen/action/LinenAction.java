package cn.azrael.main.linen.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.jasper.tagplugins.jstl.core.Set;
import org.apache.log4j.pattern.LineSeparatorPatternConverter;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.azrael.main.core.action.BaseAction;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.facilitie.entity.Facilitie;
import cn.azrael.main.facilitie.service.FacilitieService;
import cn.azrael.main.linen.entity.Linen;
import cn.azrael.main.linen.entity.LinensInfo;
import cn.azrael.main.linen.service.LinenService;
import cn.azrael.main.linen.service.LinensInfoService;
import cn.azrael.main.linen.service.impl.LinensInfoServiceImpl;
import cn.azrael.main.user.service.EmployeeService;

public class LinenAction extends BaseAction{
	@Resource
	private LinenService linenService;
	@Resource
	private FacilitieService facilitieService;
	@Resource
	private LinensInfoService linensInfoService;
	@Resource
	private EmployeeService employeeService;
	private Linen linen;
	private List<LinensInfo> linensInfo;
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
	 * 报废布草
	 */
	public String invalid(){
		//加载布草种类列表
		ActionContext.getContext().getContextMap().put("facilitieList", facilitieService.findByType(1));
		try {
			if(facilitie!=null && facilitie.getId()!=null){
				int badNum = 0;
				if(facilitie.getBadNum() > 0){
					badNum = facilitie.getBadNum();
					facilitie = facilitieService.findObjectById(facilitie.getId());
					facilitie.setBadNum((facilitie.getBadNum()+badNum));
					facilitie.setNormalNum(facilitie.getNormalNum()-badNum);
					facilitieService.update(facilitie);
					message = "提交成功！";
				}else{
					message = "请核查你填的数据！";
				}
			}
		} catch (Exception e) {
			message = "提交失败";
			throw new RuntimeException();
		}
		return "invalid";
	}
	/**
	 * 添加页面
	 */
	public String add() throws Exception{
		if(linensInfo!=null){
			for(LinensInfo ls:linensInfo){
				System.out.println(ls);
			}
		}
		//加载布草种类列表
		ActionContext.getContext().getContextMap().put("facilitieList", facilitieService.findByType(1));
		try {
			//判断传入信息不为空
			if(linen!=null && linensInfo!=null){
				if(StringUtils.isNotBlank(linen.getEmployeeId().getName())){
					//获取负责人的信息
					linen.setEmployeeId(employeeService.findByName(linen.getEmployeeId().getName()));
					if(linen.getEmployeeId()!=null){
						//保存清单
						linenService.save(linen);
						//保存清单详细
						for(LinensInfo ls: linensInfo){
							if(ls == null){
								continue;
							}
							ls.setLinenId(linen);
							linensInfoService.save(ls);
						}
						message = "添加成功!";
					}else{
						message = "没有此员工!";
					}
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
		if(linen!=null && linen.getId()!=null){
			linen = linenService.findObjectById(linen.getId());
		}
		return "editUI";
	}
	/**
	 * 编辑
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
	 * 批量删除
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
	public List<LinensInfo> getLinensInfo() {
		return linensInfo;
	}
	public void setLinensInfo(List<LinensInfo> linensInfo) {
		this.linensInfo = linensInfo;
	}
	
	
	
	
}
