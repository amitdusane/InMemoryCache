package com.cache.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Currency implements Serializable {
	
	private static final long serialVersionUID = 1497010856265912133L;
	
	private int currencyId;
	private String currencyCode;
	private String currencyName;
	private String currencySymbol;
	private int statusInd;
	private Timestamp lastModifyDate;
	private int modifyPersonNumber;
	
	public Currency() {}	
	
	public Currency(int currencyId, String currencyCode, String currencyName,
			String currencySymbol, int statusInd, Timestamp lastModifyDate,
			int modifyPersonNumber) {
		super();
		this.currencyId = currencyId;
		this.currencyCode = currencyCode;
		this.currencyName = currencyName;
		this.currencySymbol = currencySymbol;
		this.statusInd = statusInd;
		this.lastModifyDate = lastModifyDate;
		this.modifyPersonNumber = modifyPersonNumber;
	}
	
	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
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
		return "Currency [currencyId=" + currencyId + ", currencyCode="
				+ currencyCode + ", currencyName=" + currencyName
				+ ", currencySymbol=" + currencySymbol + ", statusInd="
				+ statusInd + ", lastModifyDate=" + lastModifyDate
				+ ", modifyPersonNumber=" + modifyPersonNumber + "]";
	}	
}
