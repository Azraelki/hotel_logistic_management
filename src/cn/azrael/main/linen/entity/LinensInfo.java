package cn.azrael.main.linen.entity;

import java.io.Serializable;

import cn.azrael.main.facilitie.entity.Facilitie;

/**
 * 布草收发信息实体类
 * @author lenovo
 *
 */
public class LinensInfo implements Serializable{
	private static final long serialVersionUID = -8213398453050321800L;
	
	private String id;
	private Linen linenId;//所属清单编号
	private Facilitie facilitieId;//设施：布草信息
	private Integer recNum;//当日收回数量
	private Integer senNum;//当日送出数量
	private Integer backWashNum;//回戏数量
	private Integer oweNum;//欠收数量
	
	public LinensInfo() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Linen getLinenId() {
		return linenId;
	}

	public void setLinenId(Linen linenId) {
		this.linenId = linenId;
	}

	public Facilitie getFacilitieId() {
		return facilitieId;
	}

	public void setFacilitieId(Facilitie facilitieId) {
		this.facilitieId = facilitieId;
	}

	public Integer getRecNum() {
		return recNum;
	}

	public void setRecNum(Integer recNum) {
		this.recNum = recNum;
	}

	public Integer getSenNum() {
		return senNum;
	}

	public void setSenNum(Integer senNum) {
		this.senNum = senNum;
	}

	public Integer getBackWashNum() {
		return backWashNum;
	}

	public void setBackWashNum(Integer backWashNum) {
		this.backWashNum = backWashNum;
	}

	public Integer getOweNum() {
		return oweNum;
	}

	public void setOweNum(Integer oweNum) {
		this.oweNum = oweNum;
	}

	@Override
	public String toString() {
		return "LinensInfo [id=" + id + ", linenId=" + linenId
				+ ", facilitieId=" + facilitieId + ", recNum=" + recNum
				+ ", senNum=" + senNum + ", backWashNum=" + backWashNum
				+ ", oweNum=" + oweNum + "]";
	}
	
	
}
