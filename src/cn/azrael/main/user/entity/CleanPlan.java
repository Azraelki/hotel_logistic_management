package cn.azrael.main.user.entity;

import java.io.Serializable;
/**
 * 计划卫生实体类
 * @author lenovo
 *
 */
public class CleanPlan implements Serializable{
	private static final long serialVersionUID = 3597853221278554711L;

	private String id;
	private Employee employeeId;
	private String content;
	private Double begin;
	private Double end;
	public CleanPlan() {
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Double getBegin() {
		return begin;
	}
	public void setBegin(Double begin) {
		this.begin = begin;
	}
	public Double getEnd() {
		return end;
	}
	public void setEnd(Double end) {
		this.end = end;
	}
	
	
}
