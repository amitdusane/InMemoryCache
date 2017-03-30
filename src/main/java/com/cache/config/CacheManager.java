package com.cache.config;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;

/**
 * A singleton class which configures cache properties
 * @author amitd
 *
 */
public final class CacheManager implements Serializable{
	final static Logger log = Logger.getLogger(CacheManager.class);

	private static final long serialVersionUID = -3543198383631858942L;

	private static CacheManager cacheManager = null;
	
	public static LoadingCache<CacheKey, Object> databaseCache = null;
	
	public static final CacheManager getInstance(){		
		
		if(cacheManager == null){
			
			synchronized (CacheManager.class) {
				
				if(cacheManager == null){
					cacheManager =  new CacheManager();
				}
			}			
			
		}
		return cacheManager;
	}
	
	
	static{
		log.debug("Cache configuration starts");
		
		 //create a database cache for different objects like Country, Currency, and Holiday
		databaseCache = 
	         CacheBuilder.newBuilder()
	            .maximumSize(10000) // maximum 10000 records can be cached
	            .expireAfterAccess(30, TimeUnit.MINUTES) // cache will expire after 30 minutes of access
	            .build(new CacheLoaderHelper());
		
		log.debug("Cache configuration ends");
	}
	
	private CacheManager(){
		
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	protected Object readResolve() {
		return getInstance();
	}
}
