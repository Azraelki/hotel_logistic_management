package cn.azrael.main.user.entity;

import java.io.Serializable;

public class Job implements Serializable{
	private static final long serialVersionUID = 2203812691566707205L;
	
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", name=" + name + "]";
	}
	
	

}
