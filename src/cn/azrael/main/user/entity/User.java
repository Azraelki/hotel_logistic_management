package cn.azrael.main.user.entity;

import java.io.Serializable;
/**
 * 用户实体类
 * @author azrael
 *
 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Employee employeeId;
	private int type;
	private String password;
	

	public void setId(String id) {
		this.id = id;
	}
	public Employee getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", employeeId=" + employeeId + ", type=" + type
				+ ", password=" + password + "]";
	}
	
}
