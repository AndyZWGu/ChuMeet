package com.member.model;

public class POIVO implements java.io.Serializable {
	private Integer POIID;
	private String POINameC;
	private String POIName;
	private String POIAbr;
	
	public Integer getPOIID() {
		return POIID;
	}
	public void setPOIID(Integer pOIID) {
		POIID = pOIID;
	}
	public String getPOINameC() {
		return POINameC;
	}
	public void setPOINameC(String pOINameC) {
		POINameC = pOINameC;
	}
	public String getPOIName() {
		return POIName;
	}
	public void setPOIName(String pOIName) {
		POIName = pOIName;
	}
	public String getPOIAbr() {
		return POIAbr;
	}
	public void setPOIAbr(String pOIAbr) {
		POIAbr = pOIAbr;
	}

}
