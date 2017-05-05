package cn.azrael.main.food.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.food.dao.FoodDao;
import cn.azrael.main.food.entity.Food;
import cn.azrael.main.food.service.FoodService;
@Service("foodService")
public class FoodServiceImpl extends BaseServiceImpl<Food> implements FoodService{
	private FoodDao foodDao;
	@Resource
	public void setFoodDao(FoodDao foodDao) {
		setBaseDao(foodDao);
		this.foodDao = foodDao;
	}
	@Override
	public Food findByName(String name) {
		QueryHelper queryHelper = new QueryHelper(Food.class, "f");
		queryHelper.addCondition("f.name=?", name);
		List<Food> list = foodDao.findObjects(queryHelper);
		if(list.size()>0)
			return list.get(0);
		return null;
	}
}
