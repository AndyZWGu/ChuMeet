package com.member.model;

public class AchVO implements java.io.Serializable{
	private Integer achID;
	private String rewID;
	private String achName;
	private String achDesc;
	private Integer achStatus;
	
	public Integer getAchID() {
		return achID;
	}
	public void setAchID(Integer achID) {
		this.achID = achID;
	}
	public String getRewID() {
		return rewID;
	}
	public void setRewID(String rewID) {
		this.rewID = rewID;
	}
	public String getAchName() {
		return achName;
	}
	public void setAchName(String achName) {
		this.achName = achName;
	}
	public String getAchDesc() {
		return achDesc;
	}
	public void setAchDesc(String achDesc) {
		this.achDesc = achDesc;
	}
	public Integer getAchStatus() {
		return achStatus;
	}
	public void setAchStatus(Integer achStatus) {
		this.achStatus = achStatus;
	}
	
}
