package cn.azrael.main.purchase.entity;

import java.io.Serializable;

import cn.azrael.main.facilitie.entity.Facilitie;

public class FacilitieUse implements Serializable{
	private static final long serialVersionUID = -5977605818254012378L;

	private String id;
	private Facilitie facilitieId;
	private Integer useNum;
	private Double date;
	public FacilitieUse() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Facilitie getFacilitieId() {
		return facilitieId;
	}
	public void setFacilitieId(Facilitie facilitieId) {
		this.facilitieId = facilitieId;
	}
	public Integer getUseNum() {
		return useNum;
	}
	public void setUseNum(Integer useNum) {
		this.useNum = useNum;
	}
	public Double getDate() {
		return date;
	}
	public void setDate(Double date) {
		this.date = date;
	}
	
	
}
