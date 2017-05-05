package cn.azrael.main.food.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.food.dao.FoodShowDao;
import cn.azrael.main.food.entity.FoodShow;
import cn.azrael.main.food.service.FoodShowService;

@Service("foodShowService")
public class FoodShowServiceImpl extends BaseServiceImpl<FoodShow> implements FoodShowService{
	private FoodShowDao foodShowDao;
	@Resource
	public void setFoodShowDao(FoodShowDao foodShowDao) {
		setBaseDao(foodShowDao);
		this.foodShowDao = foodShowDao;
	}
}
