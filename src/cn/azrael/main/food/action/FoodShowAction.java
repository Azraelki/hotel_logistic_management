package cn.azrael.main.food.action;

import java.util.List;

import javax.annotation.Resource;





import org.apache.commons.lang3.StringUtils;

import cn.azrael.main.core.action.BaseAction;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.food.entity.Food;
import cn.azrael.main.food.entity.FoodShow;
import cn.azrael.main.food.service.FoodService;
import cn.azrael.main.food.service.FoodShowService;

public class FoodShowAction extends BaseAction{
	@Resource
	private FoodShowService foodShowService;
	@Resource
	private FoodService foodService;
	private FoodShow foodShow;
	private Food food;
	private List<Food> foods;
	private List<FoodShow> foodShows;
	private String message;
	private Double beginDate;
	private Double endDate;
	private Double nowDate;
	
	public String execute(){
		return "default";
	}
	/**
	 * 展示菜单列表信息
	 */
	public String info() throws Exception{
		QueryHelper queryHelper = new QueryHelper(FoodShow.class, "fs");
		try {
			System.out.println(pageNo);
			if(beginDate != null){
				System.out.println(beginDate);
				queryHelper.addCondition("fs.date >= ?", beginDate);
			}
			if(endDate != null){
				System.out.println(endDate);
				queryHelper.addCondition("fs.date <= ?", endDate);
			}
			queryHelper.addOrderByProperty("fs.date", QueryHelper.ORDER_BY_DESC);
			pageResult = foodShowService.getPageResult(queryHelper, this.getPageNo(), this.getPageSize());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return "info";
	}
	/**
	 * ajax请求菜品信息
	 */
	public String foodJson()throws Exception{
		QueryHelper queryHelper = new QueryHelper(Food.class, "f");
		if(food!=null){
			if(StringUtils.isNotBlank(food.getName())){
				queryHelper.addCondition("f.status=?", true);
				queryHelper.addCondition("f.name like ?", "%"+food.getName().replace(" ", "")+"%");
			}
		}
		foods = foodService.findObjects(queryHelper);
		return "json";
	}
	/**
	 * 添加菜单
	 */
	public String add() throws Exception{
		if(foodShows!=null){
			try {
				System.out.println(foodShows.get(0).getFoodId().getId());
				if(nowDate!=null){
					for (FoodShow fs : foodShows) {
						if(fs == null){
							continue;
						}
						if(fs.getFoodId().getId().length() < 30){
							food = foodService.findByName(fs.getFoodId().getId());
							if(food == null)
								continue;
							fs.setFoodId(food);
						}
						fs.setDate(nowDate);
						foodShowService.save(fs);
					}
					message = "添加成功！";
				}else{
					message = "日期不能为空";
				}
			} catch (Exception e) {
				message = "添加失败";
				throw new Exception(e.getMessage());
			}
		}
		return "add";
	}
	/**
	 * 删除单个员工
	 */
	public String delete() throws Exception{
		try {
			foodShowService.delete(foodShow.getId());
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
					foodShowService.delete(s);
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
			}
		}
		return "list";
	}
	public FoodShow getFoodShow() {
		return foodShow;
	}
	public void setFoodShow(FoodShow foodShow) {
		this.foodShow = foodShow;
	}
	public List<FoodShow> getFoodShows() {
		return foodShows;
	}
	public void setFoodShows(List<FoodShow> foodShows) {
		this.foodShows = foodShows;
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
	public Double getNowDate() {
		return nowDate;
	}
	public void setNowDate(Double nowDate) {
		this.nowDate = nowDate;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public List<Food> getFoods() {
		return foods;
	}
	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}
	
	
}
