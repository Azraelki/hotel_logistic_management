package cn.azrael.main.facilitie.action;

import java.net.URLDecoder;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionContext;

import cn.azrael.main.core.action.BaseAction;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.facilitie.entity.Facilitie;
import cn.azrael.main.facilitie.service.FacilitieService;

public class FacilitieAction extends BaseAction{
	@Resource
	private FacilitieService facilitieService;
	private Facilitie facilitie;
	private String message;
	public String execute(){
		return "default";
	}
	/**
	 * 设施信息展示
	 */
	public String info(){
		QueryHelper queryHelper = new QueryHelper(Facilitie.class, "f");
		try{
			System.out.println(pageNo);
			if(facilitie!=null){
				if(facilitie.getType()!=null && facilitie.getType()!=0){
					queryHelper.addCondition("f.type=?", facilitie.getType());
				}
				if(StringUtils.isNotBlank(facilitie.getName())){
					facilitie.setName(URLDecoder.decode(facilitie.getName(), "utf-8"));
					queryHelper.addCondition("f.name like ?", "%"+facilitie.getName()+"%");
				}
			}
			pageResult = facilitieService.getPageResult(queryHelper, this.getPageNo(), this.getPageSize());
		}catch(Exception e){
			throw new RuntimeException();
		}
		return "info";
	}
	/**
	 * 报废
	 */
	/*public String invalid(){
		//加载布草种类列表
		ActionContext.getContext().getContextMap().put("facilitieList", facilitieService.findByType(1));
		try {
			if(facilitie!=null && facilitie.getId()!=null){
				if(facilitie.getBadNum() > 0){
					facilitieService.invalidAndUpdate(facilitie);
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
	}*/
	/**
	 * 添加页面
	 */
	public String add() throws Exception{
		try {
			//判断传入信息不为空
			if(facilitie!=null){
				if(facilitie.getType()!=0){
					facilitieService.save(facilitie);
					message = "添加成功！";
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
		if(facilitie!=null && facilitie.getId()!=null){
			facilitie = facilitieService.findObjectById(facilitie.getId());
		}
		return "editUI";
	}
	/**
	 * 编辑
	 */
	public String edit(){
		try {
			if(facilitie!=null && facilitie.getId()!=null){
				facilitieService.update(facilitie);
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
			if(facilitie!=null && facilitie.getId()!=null){
				facilitieService.delete(facilitie.getId());
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
					facilitieService.delete(s);
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
			}
		}
		return "list";
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
	
}
