package com.smforj.ssm.util;


/***
 * ErrorUtil文件工具类
 * 
 * @author Haijun Gao 
 * @date 2016-7-23 上午10:30:48
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public class ErrorUtil {   
	private final static String FILENAME = "error.properties"; 
	private ErrorUtil() {}  
	
	public static Prop getProp() { 
		return PropKit.use(FILENAME);  
	} 
	
	public static String get(String key) { 
		return getProp().get(key);
	}
	
	public static String get(String key, String defaultValue) {
		return getProp().get(key, defaultValue);
	}
	
	public static Integer getInt(String key) {
		return getProp().getInt(key);
	}
	
	public static Integer getInt(String key, Integer defaultValue) {
		return getProp().getInt(key, defaultValue);
	}
	
	public static Long getLong(String key) {
		return getProp().getLong(key);
	}
	
	public static Long getLong(String key, Long defaultValue) {
		return getProp().getLong(key, defaultValue);
	}
	
	public static Boolean getBoolean(String key) {
		return getProp().getBoolean(key) ;
	}
	
	public static Boolean getBoolean(String key, Boolean defaultValue) {
		return getProp().getBoolean(key, defaultValue);
	}
	
	public static boolean containsKey(String key) {
		return getProp().containsKey(key);
	}
}

