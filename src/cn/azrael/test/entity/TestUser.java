package cn.azrael.test.entity;

import java.io.Serializable;

public class TestUser implements Serializable{
	private String id;
	private String name;
	public TestUser() {
	}
	public TestUser( String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
		return "TestUser [id=" + id + ", name=" + name + "]";
	}
	
}
