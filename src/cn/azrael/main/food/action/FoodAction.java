package cn.azrael.main.food.action;

import java.net.URLDecoder;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;




import com.opensymphony.xwork2.ActionContext;

import cn.azrael.main.core.action.BaseAction;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.food.entity.Food;
import cn.azrael.main.food.service.FoodService;
import cn.azrael.main.food.util.FoodUtil;

public class FoodAction extends BaseAction{
	@Resource
	private FoodService foodService;
	private Food food;
	private String message;
	
	public String execute(){
		return "default";
	}
	/**
	 * 菜品列表信息
	 */
	public String info() throws Exception{
		QueryHelper queryHelper = new QueryHelper(Food.class, "f");
		//加载菜品类型
		ActionContext.getContext().getContextMap().put("foodTypeList", FoodUtil.getFoodTypes());
		try {
			System.out.println(pageNo);
			if(food!=null){
				if(StringUtils.isNotBlank(food.getName())){
					food.setName(URLDecoder.decode(food.getName(), "utf-8"));
					queryHelper.addCondition("f.name like ?", "%"+food.getName()+"%");
				}
				if(food.getType()!=null && food.getType()!=0){
					queryHelper.addCondition("f.type=?", food.getType());
				}
			}
			pageResult = foodService.getPageResult(queryHelper, this.getPageNo(), this.getPageSize());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return "info";
	}
	/**
	 * 添加菜品
	 */
	public String add() throws Exception{
		//加载菜品类型
		ActionContext.getContext().getContextMap().put("foodTypeList", FoodUtil.getFoodTypes());
		if(food!=null){
			try {
				foodService.save(food);
				message = "添加成功！";
			} catch (Exception e) {
				message = "添加失败";
				throw new Exception(e.getMessage());
			}
		}
		return "add";
	}
	/**
	 * 编辑菜品页面
	 */
	public String editUI(){
		//加载菜品类型
		ActionContext.getContext().getContextMap().put("foodTypeList", FoodUtil.getFoodTypes());
		if(food!=null && food.getId()!=null){
			food = foodService.findObjectById(food.getId());
		}
		return "editUI";
	}
	/**
	 * 编辑菜品
	 */
	public String edit(){
		try {
			if(food!=null){
				foodService.update(food);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	/**
	 * 删除菜品
	 */
	public String delete() throws Exception{
		try {
			foodService.delete(food.getId());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return "list";
	}
	/**
	 * 批量删除菜品
	 */
	public String deleteSelected() throws Exception{
		if(selectedRow!=null){
			for(String s:selectedRow){
				try {
					foodService.delete(s);
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
			}
		}
		return "list";
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
