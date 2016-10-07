package com.smforj.ssm.util;

import java.util.Date;

/***
 * 时间格式化工具类
 * 
 * @author Haijun Gao 
 * @date 2016-8-4 上午10:52:03
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public final class DateFormat {
	
	public static final String FORMATDEFAULT = "yyyy-MM-dd hh:mm:ss";
	public static final String FORMATDATE = "yyyy-MM-dd";
	
	/***
	 * format = "yyyy-MM-dd hh:mm:ss" 输出格式: 2006-01-01 00:00:00 
	 * @param format 格式化
	 * @return 格式化后的时间字符串
	 * @date 2016-8-4 上午10:51:28
	 */
	public static String dateToString(String format)
	{ 
        return dateToString(new Date(),format);
	}
	
	
	/***
	 * format = "yyyy-MM-dd hh:mm:ss" 输出格式: 2006-01-01 00:00:00 
	 * @param format 格式化
	 * @return 格式化后的时间字符串
	 * @date 2016-8-4 上午10:51:28
	 */
	public static String dateToString(Date date,String format)
	{
        /** format = "yyyy-MM-dd hh:mm:ss" 输出格式: 2006-01-01 00:00:00 */
        java.text.DateFormat format1 = new java.text.SimpleDateFormat(format);
        String s = format1.format(date);
        System.out.println(s);
        return s;
	}
	
	
	public static void main(String[] agrs)
	{
		System.out.println(DateFormat.dateToString("yyyyMMdd    HHmmss"));
	}

}
