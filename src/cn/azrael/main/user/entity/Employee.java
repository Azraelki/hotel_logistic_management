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
	private Job jobId;
	private String name;
	private boolean gender;
	private Integer age;
	private String phoneNumber;
	private Double arrivedAt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Job getJobId() {
		return jobId;
	}
	public void setJobId(Job jobId) {
		this.jobId = jobId;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Double getArrivedAt() {
		return arrivedAt;
	}
	public void setArrivedAt(Double arrivedAt) {
		this.arrivedAt = arrivedAt;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", jobId=" + jobId + ", name=" + name
				+ ", gender=" + gender + ", age=" + age + ", phoneNumber="
				+ phoneNumber + ", arrivedAt=" + arrivedAt + "]";
	}
	

	
}
