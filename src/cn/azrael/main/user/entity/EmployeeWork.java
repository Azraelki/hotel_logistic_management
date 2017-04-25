package cn.azrael.main.user.entity;

import java.io.Serializable;

public class EmployeeWork implements Serializable{
	private static final long serialVersionUID = -1327026653221928753L;
	
	private String id;
	private Employee employeeId;
	private Integer leaveNum;
	private Integer cleanNum;
	private Double date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Employee getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getLeaveNum() {
		return leaveNum;
	}
	public void setLeaveNum(Integer leaveNum) {
		this.leaveNum = leaveNum;
	}
	public Integer getCleanNum() {
		return cleanNum;
	}
	public void setCleanNum(Integer cleanNum) {
		this.cleanNum = cleanNum;
	}
	public Double getDate() {
		return date;
	}
	public void setDate(Double date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "EmployeeWork [id=" + id + ", employeeId=" + employeeId
				+ ", leaveNum=" + leaveNum + ", cleanNum=" + cleanNum
				+ ", date=" + date + "]";
	}
	

	
	
}
