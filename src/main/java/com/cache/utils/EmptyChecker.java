package com.cache.utils;

import java.util.Collection;

/**
 * <code>EmptyChecker</code> is used to check whether object is null and empty.
 * @author Amit Dusane
 */

public class EmptyChecker {

	private EmptyChecker() {}
	
	public static boolean isValued(Object value) {
		return !isEmpty(value);
	}

	public static boolean isEmpty(Object value) {
		if (value == null)
			return true;

		if (String.class.isAssignableFrom(value.getClass()))
			return ((String)value).trim().equals("");

		if (Collection.class.isAssignableFrom(value.getClass())) {
			try {
				return ((Collection<?>)value).isEmpty();
			}
			catch (Exception ex) {
				return true;
			}
		}

		if (value.getClass().isArray())
			return ((Object[])value).length == 0;

		return false;
	}

	public static String nullIfEmpty(String s) {
		if (s == null)
			return null;

		String temp = s.trim();
		return temp.equals("") ? null : temp;
	}
	
	public static String emptyIfNull(String s) {
		if (s == null)
			return "";

		return s;
	}
}

