package cn.azrael.main.food.util;

import java.util.ArrayList;
import java.util.List;

import cn.azrael.main.food.entity.FoodType;
/**
 * 菜品类型工具类
 * @author lenovo
 *
 */
public class FoodUtil {
	private static List<FoodType> FoodTypeList;
	static{
		FoodTypeList = new ArrayList<FoodType>();
		FoodTypeList.add(new FoodType(1, "主食"));
		FoodTypeList.add(new FoodType(2, "煲汤"));
		FoodTypeList.add(new FoodType(3, "烘焙"));
		FoodTypeList.add(new FoodType(4, "甜点"));
		FoodTypeList.add(new FoodType(5, "饮品"));
		FoodTypeList.add(new FoodType(6, "炒菜"));
		FoodTypeList.add(new FoodType(7, "零食"));
		FoodTypeList.add(new FoodType(8, "海鲜"));
	}
	public static List<FoodType> getFoodTypes(){
		return FoodTypeList;
	}
}
