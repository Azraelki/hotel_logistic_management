package cn.azrael.main.food.service;

import cn.azrael.main.core.service.BaseService;
import cn.azrael.main.food.entity.Food;

public interface FoodService extends BaseService<Food>{
	//根据名称查询
	public Food findByName(String name);
}
