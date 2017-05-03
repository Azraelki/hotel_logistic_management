package cn.azrael.main.purchase.entity;

import java.io.Serializable;

import cn.azrael.main.facilitie.entity.Facilitie;

public class PurchaseInfo implements Serializable{
	private static final long serialVersionUID = -5351613486451114427L;
	
	private String id;
	private PurchaseOrder purchaseOrderId;
	private Facilitie facilitieId;
	private Integer purchaseNum;
	private Double price;
	private Double total;
	public PurchaseInfo() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public PurchaseOrder getPurchaseOrderId() {
		return purchaseOrderId;
	}
	public void setPurchaseOrderId(PurchaseOrder purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}
	public Facilitie getFacilitieId() {
		return facilitieId;
	}
	public void setFacilitieId(Facilitie facilitieId) {
		this.facilitieId = facilitieId;
	}
	public Integer getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(Integer purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	
}
