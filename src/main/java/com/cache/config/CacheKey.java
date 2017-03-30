package com.cache.config;

import java.io.Serializable;
/**
 * An immutable class that encapsulates database table name and primary key value
 * @author amitd
 *
 */
public final class CacheKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2735634368470334579L;

	private final String tableName;
	private final int primaryKeyValue;	
	
	public CacheKey(String tableName, int primaryKeyValue) {
		super();
		this.tableName = tableName;
		this.primaryKeyValue = primaryKeyValue;
	}

	public String getTableName() {
		return tableName;
	}
	
	public int getPrimaryKeyValue() {
		return primaryKeyValue;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + primaryKeyValue;
		result = prime * result
				+ ((tableName == null) ? 0 : tableName.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CacheKey other = (CacheKey) obj;
		if (primaryKeyValue != other.primaryKeyValue)
			return false;
		if (tableName == null) {
			if (other.tableName != null)
				return false;
		} else if (!tableName.equals(other.tableName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CacheKey [tableName=" + tableName + ", primaryKeyValue="
				+ primaryKeyValue + "]";
	}	
	
}
