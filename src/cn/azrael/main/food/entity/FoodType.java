package cn.azrael.main.food.entity;

public class FoodType {
	private Integer code;
	private String name;
	public FoodType() {
	}
	public FoodType(Integer code, String name) {
		this.code = code;
		this.name = name;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
