package com.smforj.ssm.util;

/***
 * 字符串处理工具类
 * 
 * @author Haijun Gao 
 * @date 2016-8-4 下午4:00:39
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public final class StringEx { 
	
	/***
	 * 判断是否为Null 或 ""
	 * @param str 要判断的字符串
	 * @return 为Null 或 "" true  否则false
	 * @date 2016-8-4 下午4:01:39
	 */
	public static Boolean isExEmpty(String str)
	{
		if(str == null || str.trim() == "")
			return true;
		return false;
	}
	/**
	 * 字符串首字母小写
	 * @param str
	 * @return
	 */
	public static String toLowerCaseFirstOne(String str) {
		if (str == null || "".equals(str.trim()))
			return str;
		str = str.trim();
		if (Character.isLowerCase(str.charAt(0)))
			return str;
		else
			return (new StringBuilder()).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1))
					.toString();
	}

	/**
	 * 字符串首字母大写
	 * @param str
	 * @return
	 */
	public static String toUpperCaseFirstOne(String str) {
		if (str == null || "".equals(str.trim()))
			return str;
		str = str.trim();
		if (Character.isUpperCase(str.charAt(0)))
			return str;
		else
			return (new StringBuilder()).append(Character.toUpperCase(str.charAt(0))).append(str.substring(1))
					.toString();
	}
}
