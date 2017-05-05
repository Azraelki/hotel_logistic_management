package cn.azrael.main.food.entity;

import java.io.Serializable;
import java.util.Set;

public class FoodShow implements Serializable{
	private static final long serialVersionUID = -3050932251852102240L;

	private String id;
	private Food foodId;
	private Double date;
	public FoodShow() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Food getFoodId() {
		return foodId;
	}
	public void setFoodId(Food foodId) {
		this.foodId = foodId;
	}
	public Double getDate() {
		return date;
	}
	public void setDate(Double date) {
		this.date = date;
	}
}
