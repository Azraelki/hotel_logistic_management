package cn.azrael.main.user.entity;

import java.io.Serializable;

public class Role implements Serializable{
	private static final long serialVersionUID = 1794200755894463216L;
	
	private String id;
	private Integer type;
	private String privilege;
	public Role() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	
	
}
