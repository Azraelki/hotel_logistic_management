package cn.azrael.main.linen.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import cn.azrael.main.user.entity.Employee;
/**
 * 布草收发清单实体类
 * @author lenovo
 *
 */
public class Linen implements Serializable{
	private static final long serialVersionUID = 7067747713803828603L;
	
	private String id;
	private Employee employeeId;//负责人
	private Set<LinensInfo> linensInfos = new HashSet<LinensInfo>();
	private Double date;
	public Linen() {
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
	public Set<LinensInfo> getLinensInfos() {
		return linensInfos;
	}
	public void setLinensInfos(Set<LinensInfo> linensInfos) {
		this.linensInfos = linensInfos;
	}
	@Override
	public String toString() {
		return "Linen [id=" + id + ", employeeId=" + employeeId
				+ ", linensInfos=" + linensInfos + ", date=" + date + "]";
	}
	
	
}
