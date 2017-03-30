package com.cache;

import java.util.concurrent.ExecutionException;

import org.apache.log4j.Logger;

import com.cache.config.CacheKey;
import com.cache.config.CacheManager;
import com.cache.utils.EmptyChecker;

public class InMemoryCache {
	final static Logger log = Logger.getLogger(InMemoryCache.class);
		
	/**
	 * Fetches data from cache using table name and primary key value.
	 * If not present in cache, database will be hit to get details and added to cache for later use.
	 * @param tableName
	 * @param primaryKeyValue
	 * @return
	 */
	public static Object getObject(String tableName, int primaryKeyValue){
		
		if(EmptyChecker.isEmpty(tableName)){
			log.warn("Table name is - " + tableName + " returning NULL");
			return null;
		}			
		
		try {
			return CacheManager.databaseCache.get(new CacheKey(tableName, primaryKeyValue));			
		} catch (ExecutionException e) {
			log.error("Exception occured while accessing cached object, Table name - " + tableName + ", Primary key value - " + primaryKeyValue +" \n"
					+ "Exception: " + e);
			return null;			
		} catch (Exception e){
			log.error("Exception occured while accessing cached object, Table name - " + tableName + ", Primary key value - " + primaryKeyValue +" \n"
					+ "Exception: " + e);
			return null;		
		}
	}	
	
	
	/**
	 * Remove record manually from cache using table name and primary key value
	 * @param tableName
	 * @param primaryKeyValue
	 */
	public static void removeManually(String tableName, int primaryKeyValue){
				
		if(EmptyChecker.isEmpty(tableName)){
			System.out.println("Table name is - " + tableName + " returning NULL");
			return;
		}
		
		log.warn("Removing record from cache, Table name - " + tableName + ", Primary key value - " + primaryKeyValue );
		try {		
			CacheManager.databaseCache.invalidate(new CacheKey(tableName, primaryKeyValue));		
		} catch (Exception e) {
			log.error("Exception occured while removing cached object, Table name - " + tableName + ", Primary key value - " + primaryKeyValue +" \n"
					+ "Exception: " + e);			
		}	
	}
	
	public static void removeAllManually(){
				
		log.warn("Removing all records from cache");
		try {		
			CacheManager.databaseCache.invalidateAll();		
		} catch (Exception e) {
			log.error("Exception occured while removing all cached objects. \nException: " + e);			
		}	
	}
	
	/**
	 * Reload the record in cache after data update in database
	 * @param tableName
	 * @param primaryKeyValue
	 */
	public static void reload(String tableName, int primaryKeyValue){
		
		log.info("Reloading cache, Table name - " + tableName + ", Primary key value - " + primaryKeyValue);
		
		try {
			CacheManager.databaseCache.refresh(new CacheKey(tableName, primaryKeyValue));
		} catch (Exception e) {	
			log.error("Exception occured while refreshing cached object, Table name - " + tableName + ", Primary key value - " + primaryKeyValue +" \n"
					+ "Exception: " + e);			
			
		}	
	}
	
}
