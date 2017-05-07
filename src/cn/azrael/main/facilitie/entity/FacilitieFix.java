package cn.azrael.main.facilitie.entity;

import java.io.Serializable;

import cn.azrael.main.user.entity.Employee;

/**
 * 维护信息实体
 * @author lenovo
 *
 */
public class FacilitieFix implements Serializable{
	private static final long serialVersionUID = 5293614883107483766L;
	
	private String id;
	private Employee employeeId;
	private Facilitie facilitieId;
	private Integer status;
	private String contnet;
	private Double dateBegin;
	private Double dateEnd;
	public FacilitieFix() {
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
	public Facilitie getFacilitieId() {
		return facilitieId;
	}
	public void setFacilitieId(Facilitie facilitieId) {
		this.facilitieId = facilitieId;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getContnet() {
		return contnet;
	}
	public void setContnet(String contnet) {
		this.contnet = contnet;
	}
	public Double getDateBegin() {
		return dateBegin;
	}
	public void setDateBegin(Double dateBegin) {
		this.dateBegin = dateBegin;
	}
	public Double getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Double dateEnd) {
		this.dateEnd = dateEnd;
	}
	
	
	
}
