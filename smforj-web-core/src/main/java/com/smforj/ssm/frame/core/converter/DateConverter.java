package com.smforj.ssm.frame.core.converter; 

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

/***
 * 时间转换对象
 * 
 * @author Haijun Gao 
 * @date 2016-7-22 下午4:55:59
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public class DateConverter implements Converter<String, Date> {  
	@Override
	public Date convert(String source) { 
			try {
				return DateUtils.parseDate(source, "yyyy-MM-dd", "yyyy-MM-dd hh:mm:ss");
			} catch (ParseException e) { 
				e.printStackTrace();
			}
			return null; 
	}
}
