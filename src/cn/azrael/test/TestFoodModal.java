package cn.azrael.test;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.azrael.main.food.entity.Food;
import cn.azrael.main.food.entity.FoodShow;
import cn.azrael.main.food.service.FoodService;
import cn.azrael.main.food.service.FoodShowService;

public class TestFoodModal {
	private ApplicationContext ac;
	private FoodService fs;
	private FoodShowService fss;
	@Before
	public void loadCtx(){
		ac = new ClassPathXmlApplicationContext(new String[] {"classpath:spring.xml"});
		fs = (FoodService) ac.getBean("foodService");
		fss = (FoodShowService) ac.getBean("foodShowService");
	}
	
	@Test
	public void testFoodSave() throws Exception {
		Food food = new Food();
		for(int i = 0;i < 20;i++){
			food.setName("菜名"+i);
			food.setStyle("菜系"+i%3);
			food.setType(i%3);
			food.setStatus(true);
			food.setPrice(1.0+i);
			fs.save(food);
		}
	}
	@Test
	public void testFoodShowSave() throws Exception {
		FoodShow foodShow = new FoodShow();
		foodShow.setDate(new Date().getTime()/1000.0);
		List<Food> list = fs.findObjects();
		for (int i = 0; i < 10; i++) {
			foodShow.setFoodId(list.get(i));
			fss.save(foodShow);
		}
	}
}
