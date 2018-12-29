package com.mohsenj.core.util;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * Miscellaneous {@link String} utility methods.
 *
 * @author Mohsen Jahanshahi
 * @since 8 Febrary 2017
 */
public abstract class StringUtils {
	/*
	public static  convertNumFarsi(String matches)
    {
        Array farsi_array   = array('۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹');
        Array english_array = new Array['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];

        return str_replace($english_array, $farsi_array, $matches);
    }
	*/
    
	private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
	
    public static  String slugify(String input){
   //     $s = str_replace(' ', '-', trim($string));
     //   $s = str_replace('/', '-', $s);
        
      //  return $s;
        
    //	return "";
    	
    	if(input.isEmpty()) {
    		return "";
    	}
        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String nonSlash = nowhitespace.replace("/", "-");
   
        
        return nonSlash;
    }
    
    /*
    public static function showFarsiPrice($price)
    {
        return self::convertNumFarsi(number_format($price));
    }
    */
    
    public static String MD5(String md5) {
    	   try {
    	        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
    	        byte[] array = md.digest(md5.getBytes());
    	        StringBuffer sb = new StringBuffer();
    	        for (int i = 0; i < array.length; ++i) {
    	          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
    	       }
    	        System.out.println("md5 string "+sb.toString());
    	        return sb.toString();
    	    } catch (java.security.NoSuchAlgorithmException e) {
    	    }
    	    return null;
    	}
    /*
    public static String randomString(final int length) {
    	
    	char[] text = new char[length];
    	
    	return new String(text);
    	
       /* Random r = new Random(); // perhaps make it a class variable so you don't make a new one every time
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            char c = (char)(r.nextInt((int)(Character.MAX_VALUE)));
            sb.append(c);
        }
        return sb.toString();*/
 //   }
   
    public static String randomString(int length)
    {
    	java.util.Random rng= new java.util.Random();
    	String characters = "abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    	
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
    
}
