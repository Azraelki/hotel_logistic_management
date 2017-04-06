package cn.azrael.main.user.entity;

import java.io.Serializable;

public class EmployeeWork implements Serializable{
	private static final long serialVersionUID = -1327026653221928753L;
	
	private String id;
	private Employee employeeId;
	private int leaveNum;
	private int cleanNum;
	private double date;
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
	public int getLeaveNum() {
		return leaveNum;
	}
	public void setLeaveNum(int leaveNum) {
		this.leaveNum = leaveNum;
	}
	public int getCleanNum() {
		return cleanNum;
	}
	public void setCleanNum(int cleanNum) {
		this.cleanNum = cleanNum;
	}
	public double getDate() {
		return date;
	}
	public void setDate(double date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "EmployeeWork [id=" + id + ", employeeId=" + employeeId
				+ ", leaveNum=" + leaveNum + ", cleanNum=" + cleanNum
				+ ", date=" + date + "]";
	}
	

	
	
}
