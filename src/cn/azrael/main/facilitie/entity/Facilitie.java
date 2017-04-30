package cn.azrael.main.facilitie.entity;

import java.io.Serializable;
/**
 * 酒店设施实体
 * @author lenovo
 *
 */
public class Facilitie implements Serializable{
	private static final long serialVersionUID = 41281047888851025L;
	
	private String id;
	private String name;
	private Integer type;
	private Integer normalNum;
	private Integer badNum;
	public Facilitie() {
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getNormalNum() {
		return normalNum;
	}
	public void setNormalNum(Integer normalNum) {
		this.normalNum = normalNum;
	}
	public Integer getBadNum() {
		return badNum;
	}
	public void setBadNum(Integer badNum) {
		this.badNum = badNum;
	}
	
	
	
}
