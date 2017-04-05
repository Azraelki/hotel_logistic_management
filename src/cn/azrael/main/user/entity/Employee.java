package cn.azrael.main.user.entity;

import java.io.Serializable;

/**
 * 员工信息实体
 * @author azrael
 *
 */
public class Employee implements Serializable{
	private static final long serialVersionUID = -6342627250616250620L;
	
	private String id;
	private String name;
	private boolean gender;
	private int age;
	private String phoneNumber;
	private double arrivedAt;
	

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getArrivedAt() {
		return arrivedAt;
	}

	public void setArrivedAt(double arrivedAt) {
		this.arrivedAt = arrivedAt;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", age=" + age + ", phoneNumber=" + phoneNumber
				+ ", arrivedAt=" + arrivedAt + "]";
	}
	
	
	
}
