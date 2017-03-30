package com.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.cache.bean.Currency;

public class InMemoryCacheTest {

	@Test
	public void getObjectTest_WithValidInputs() {
		Currency currency = (Currency) InMemoryCache.getObject("REF_CURRENCY", 10);
		assertEquals("Rupee", currency.getCurrencyName());
	}
	
	@Test
	public void getObjectTest_DataNotFound() {
		Currency currency = (Currency) InMemoryCache.getObject("REF_TEST", 10);
		assertNull(currency);
	}
	
	@Test
	public void getObjectTest_IncompleteData() {
		Currency currency = (Currency) InMemoryCache.getObject("", 10);
		assertNull(currency);
	}

	@Test
	public void removeManuallyTest() {
		
		Currency currency = (Currency) InMemoryCache.getObject("REF_CURRENCY", 11);
		assertEquals("Dollar", currency.getCurrencyName());
		
		//Removing from cache
		InMemoryCache.removeManually("REF_CURRENCY", 11);
		
		//This time will be fetched from database
		Currency removedCurrency = (Currency) InMemoryCache.getObject("REF_CURRENCY", 11);
		assertEquals("Dollar", removedCurrency.getCurrencyName());
		
	}
	
	@Test
	public void removeAllManuallyTest() {
		
		Currency currency = (Currency) InMemoryCache.getObject("REF_CURRENCY", 11);
		assertEquals("Dollar", currency.getCurrencyName());
		
		//Removing all records from cache
		InMemoryCache.removeAllManually();
		
		//This time will be fetched from database
		Currency removedCurrency = (Currency) InMemoryCache.getObject("REF_CURRENCY", 11);
		assertEquals("Dollar", removedCurrency.getCurrencyName());
		
	}
	
}
