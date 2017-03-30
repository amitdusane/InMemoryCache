package com.cache.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Holiday implements Serializable {
	
	private static final long serialVersionUID = 1497010856265912133L;
	
	private int holidayId;
	private String holidayCode;
	private String holidayName;
	private Date holidayDate;
	private int statusInd;
	private Timestamp lastModifyDate;
	private int modifyPersonNumber;
	
	public Holiday() {}	

	public Holiday(int holidayId, String holidayCode, String holidayName,
			Date holidayDate, int statusInd, Timestamp lastModifyDate,
			int modifyPersonNumber) {
		super();
		this.holidayId = holidayId;
		this.holidayCode = holidayCode;
		this.holidayName = holidayName;
		this.holidayDate = holidayDate;
		this.statusInd = statusInd;
		this.lastModifyDate = lastModifyDate;
		this.modifyPersonNumber = modifyPersonNumber;
	}

	public int getHolidayId() {
		return holidayId;
	}

	public void setHolidayId(int holidayId) {
		this.holidayId = holidayId;
	}

	public String getHolidayCode() {
		return holidayCode;
	}

	public void setHolidayCode(String holidayCode) {
		this.holidayCode = holidayCode;
	}

	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public Date getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
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
		return "Holiday [holidayId=" + holidayId + ", holidayCode="
				+ holidayCode + ", holidayName=" + holidayName
				+ ", holidayDate=" + holidayDate + ", statusInd=" + statusInd
				+ ", lastModifyDate=" + lastModifyDate
				+ ", modifyPersonNumber=" + modifyPersonNumber + "]";
	}	
	
}
