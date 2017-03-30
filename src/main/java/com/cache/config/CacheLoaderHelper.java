package com.cache.config;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.cache.bean.Country;
import com.cache.bean.Currency;
import com.cache.bean.Holiday;
import com.cache.exception.DataNotFoundException;
import com.google.common.cache.CacheLoader;

public final class CacheLoaderHelper extends CacheLoader<CacheKey, Object> {
	final static Logger log = Logger.getLogger(CacheLoaderHelper.class);
	
		
	@Override
	public Object load(CacheKey key) throws Exception {
	  //make a db call to get the record
	  return getFromDatabase(key);
	}

	/**
	 * Responsible to fetch particular record from database with given table name and primary key value
	 * @param key
	 * @return
	 * @throws DataNotFoundException 
	 */
	private Object getFromDatabase(CacheKey key) throws Exception {	
		
		/*
		 * Since we do not have DAO layer in application, this(databaseReplica) is a in memory database.
		 */
		ConcurrentHashMap<CacheKey, Object> databaseReplica = new ConcurrentHashMap<CacheKey, Object>();
		
		log.info("Fetching record from database, Table name - " + key.getTableName() + ", Primary key value - " + key.getPrimaryKeyValue());
		
		Country country1 = new Country(10, "CD1", "India", 1, new Timestamp(Calendar.getInstance().getTime().getTime()), 100);
		Country country2 = new Country(11, "CD2", "America", 2, new Timestamp(Calendar.getInstance().getTime().getTime()), 101);
		Country country3 = new Country(12, "CD3", "China", 3, new Timestamp(Calendar.getInstance().getTime().getTime()), 100);
		Country country4 = new Country(13, "CD4", "Russia", 4, new Timestamp(Calendar.getInstance().getTime().getTime()), 103);
		Country country5 = new Country(14, "CD5", "Australia", 5, new Timestamp(Calendar.getInstance().getTime().getTime()), 105);
				
		databaseReplica.put(new CacheKey("REF_COUNTRY", 10), country1);
		databaseReplica.put(new CacheKey("REF_COUNTRY", 11), country2);
		databaseReplica.put(new CacheKey("REF_COUNTRY", 12), country3);
		databaseReplica.put(new CacheKey("REF_COUNTRY", 13), country4);
		databaseReplica.put(new CacheKey("REF_COUNTRY", 14), country5);
		
		Currency currency1 = new Currency(10, "CR1", "Rupee", "R", 1, new Timestamp(Calendar.getInstance().getTime().getTime()), 1001);
		Currency currency2 = new Currency(11, "CR2", "Dollar", "D", 1, new Timestamp(Calendar.getInstance().getTime().getTime()), 202);
		Currency currency3 = new Currency(12, "CR3", "Euro", "E", 1, new Timestamp(Calendar.getInstance().getTime().getTime()), 100);
		Currency currency4 = new Currency(13, "CR4", "Yen", "Y", 1, new Timestamp(Calendar.getInstance().getTime().getTime()), 100);
		Currency currency5 = new Currency(14, "CR5", "Pound", "P", 1, new Timestamp(Calendar.getInstance().getTime().getTime()), 503);
		
		databaseReplica.put(new CacheKey("REF_CURRENCY", 10), currency1);
		databaseReplica.put(new CacheKey("REF_CURRENCY", 11), currency2);
		databaseReplica.put(new CacheKey("REF_CURRENCY", 12), currency3);
		databaseReplica.put(new CacheKey("REF_CURRENCY", 13), currency4);
		databaseReplica.put(new CacheKey("REF_CURRENCY", 14), currency5);
		
		Holiday holiday1 = new Holiday(10, "HD1", "Holiday1", new Date(), 1, new Timestamp(Calendar.getInstance().getTime().getTime()), 1001);
		Holiday holiday2 = new Holiday(11, "HD2", "Holiday2", new Date(), 1, new Timestamp(Calendar.getInstance().getTime().getTime()), 1001);
		Holiday holiday3 = new Holiday(12, "HD3", "Holiday3", new Date(), 1, new Timestamp(Calendar.getInstance().getTime().getTime()), 1001);
		Holiday holiday4 = new Holiday(13, "HD4", "Holiday4", new Date(), 1, new Timestamp(Calendar.getInstance().getTime().getTime()), 1001);
		Holiday holiday5 = new Holiday(14, "HD5", "Holiday5", new Date(), 1, new Timestamp(Calendar.getInstance().getTime().getTime()), 1001);

		databaseReplica.put(new CacheKey("REF_HOLIDAY", 10), holiday1);
		databaseReplica.put(new CacheKey("REF_HOLIDAY", 11), holiday2);
		databaseReplica.put(new CacheKey("REF_HOLIDAY", 12), holiday3);
		databaseReplica.put(new CacheKey("REF_HOLIDAY", 13), holiday4);
		databaseReplica.put(new CacheKey("REF_HOLIDAY", 14), holiday5);		
		
		Object objectFound = databaseReplica.get(key);
		
		if(objectFound != null)
			return objectFound;
		else {
			throw new DataNotFoundException("Data not found, Table name - " + key.getTableName() + ", Primary key value - " + key.getPrimaryKeyValue());
		}		
		
	}
	
	
	
}

