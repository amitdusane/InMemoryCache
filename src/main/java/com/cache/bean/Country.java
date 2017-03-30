package com.cache.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Country implements Serializable {
	
	private static final long serialVersionUID = 1497010856265912133L;
	
	private int countryId;
	private String countryCode;
	private String countryName;
	private int statusInd;
	private Timestamp lastModifyDate;
	private int modifyPersonNumber;
	
	public Country() {}
	
	public Country(int countryId, String countryCode, String countryName,
			int statusInd, Timestamp lastModifyDate, int modifyPersonNumber) {
		super();
		this.countryId = countryId;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.statusInd = statusInd;
		this.lastModifyDate = lastModifyDate;
		this.modifyPersonNumber = modifyPersonNumber;
	}
	
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getStatusInd() {
		return statusInd;
	}
	public void setStatusInd(int statusInd) {
		this.statusInd = statusInd;
	}
	public Timestamp getLastModifyDate() {
		return lastModifyDate;
	}
	public void setLastModifyDate(Timestamp lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}
	public int getModifyPersonNumber() {
		return modifyPersonNumber;
	}
	public void setModifyPersonNumber(int modifyPersonNumber) {
		this.modifyPersonNumber = modifyPersonNumber;
	}
	
	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryCode="
				+ countryCode + ", countryName=" + countryName + ", statusInd="
				+ statusInd + ", lastModifyDate=" + lastModifyDate
				+ ", modifyPersonNumber=" + modifyPersonNumber + "]";
	}
	
}
