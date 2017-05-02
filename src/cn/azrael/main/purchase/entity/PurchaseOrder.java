package cn.azrael.main.purchase.entity;

import java.io.Serializable;
import java.util.Set;

import cn.azrael.main.user.entity.Employee;

public class PurchaseOrder implements Serializable{
	private static final long serialVersionUID = -1334702416339079545L;
	
	private String id;
	private Employee employeeId;
	private Double date;
	private Integer status;
	private Set<PurchaseInfo> purchaseInfos;
	public PurchaseOrder() {
	}
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
	public Double getDate() {
		return date;
	}
	public void setDate(Double date) {
		this.date = date;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Set<PurchaseInfo> getPurchaseInfos() {
		return purchaseInfos;
	}
	public void setPurchaseInfos(Set<PurchaseInfo> purchaseInfos) {
		this.purchaseInfos = purchaseInfos;
	}
}
