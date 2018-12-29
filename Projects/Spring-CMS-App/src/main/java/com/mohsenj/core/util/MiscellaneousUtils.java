package com.mohsenj.core.util;

public abstract class MiscellaneousUtils {

	/**
	 * check if given string is for admin side url
	 * @param String str is string to test
	 * @return boolean
	 */
	public static boolean isAdminSideString(String str) {
		
		if(str.startsWith("/admin")) {
			return true;
		}
		return false;
	}

}
