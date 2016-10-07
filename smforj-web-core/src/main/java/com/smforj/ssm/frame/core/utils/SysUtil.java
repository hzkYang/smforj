package com.smforj.ssm.frame.core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/***
 * 系统配置工具类
 * 
 * @author Haijun Gao 
 * @date 2016-9-5 下午5:17:00
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public class SysUtil {  
	
    private Properties properties = null;  
    private String filename = "sys.properties";
    private String encoding = "UTF-8"; 
    
    public SysUtil()
    {
    	init();
    }
    
    public SysUtil(String filename,String encoding)
    {
    	this.filename = filename;
    	this.encoding = encoding;
    	init();
    }
	/**
	 * Prop constructor
	 * <p>
	 * Example:<br>
	 * Prop prop = new Prop("my_config.txt", "UTF-8");<br>
	 * String userName = prop.get("userName");<br><br>
	 * 
	 * prop = new Prop("com/jfinal/file_in_sub_path_of_classpath.txt", "UTF-8");<br>
	 * String value = prop.get("key");
	 * 
	 * @param fileName the properties file's name in classpath or the sub directory of classpath
	 * @param encoding the encoding
	 */
	private void init() {
		InputStream inputStream = null;
		try {
			inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);		// properties.load(Prop.class.getResourceAsStream(fileName));
			if (inputStream == null)
				throw new IllegalArgumentException("Properties file not found in classpath: " + filename);
			properties = new Properties();
			properties.load(new InputStreamReader(inputStream, encoding)); 
		} catch (IOException e) {
			throw new RuntimeException("Error loading properties file.", e);
		}
		finally {
			if (inputStream != null) try {inputStream.close();} catch (IOException e) { e.printStackTrace();}
		}
	} 
	
	/***
	 * 根据key获取对象内容 
	 * @param key
	 * @return String
	 * @date 2016-9-7 上午10:36:58
	 */
	public String get(String key) { 
		return properties.getProperty(key);
	}
	/***
	 *  根据key获取对象内容
	 * @param key
	 * @param defaultValue 不存在时默认值
	 * @return String
	 * @date 2016-9-7 上午10:39:58
	 */
	public String get(String key, String defaultValue) { 
		return properties.getProperty(key, defaultValue);
	}
	
	/***
	 * 根据key获取对象内容 
	 * @param key
	 * @return int
	 * @date 2016-9-7 上午10:36:58
	 */ 
	public Integer getInt(String key) {
		return getInt(key, null);
	}
	
	/***
	 * 根据key获取对象内容 
	 * @param key
	 * @param defaultValue 不存在时默认值
	 * @return int
	 * @date 2016-9-7 上午10:40:57
	 */
	public Integer getInt(String key, Integer defaultValue) {
		String value = get(key);
		if (value != null)
			return Integer.parseInt(value.trim());
		return defaultValue;
	}
	/***
	 * 根据key获取对象内容 
	 * @param key
	 * @return Long
	 * @date 2016-9-7 上午10:36:58
	 */ 
	public Long getLong(String key) {
		return getLong(key, null);
	}
	
	/***
	 * 根据key获取对象内容 
	 * @param key
	 * @param defaultValue 不存在时默认值
	 * @return Long
	 * @date 2016-9-7 上午10:40:57
	 */
	public Long getLong(String key, Long defaultValue) {
		String value = get(key);
		if (value != null)
			return Long.parseLong(value.trim());
		return defaultValue;
	}
	/***
	 * 根据key获取对象内容 
	 * @param key
	 * @return Boolean
	 * @date 2016-9-7 上午10:36:58
	 */ 
	public Boolean getBoolean(String key) {
		return getBoolean(key, null);
	}
	/***
	 * 根据key获取对象内容 
	 * @param key
	 * @param defaultValue 不存在时默认值
	 * @return Boolean throw RuntimeException
	 * @date 2016-9-7 上午10:40:57
	 */
	public Boolean getBoolean(String key, Boolean defaultValue) {
		String value = get(key);
		if (value != null) {
			value = value.toLowerCase().trim();
			if ("true".equals(value))
				return true;
			else if ("false".equals(value))
				return false;
			throw new RuntimeException("The value can not parse to Boolean : " + value);
		}
		return defaultValue;
	}
	
	/***
	 * 是否存在key 
	 * @param key
	 * @return  boolean 存在true 否 false
	 * @date 2016-9-7 上午10:41:45
	 */
	public boolean containsKey(String key) { 
		return properties.containsKey(key);
	}
	
	/***
	 * 获取 properties 参数
	 * @return
	 * @date 2016-9-7 上午10:42:40
	 */
	public Properties getProperties() { 
		return properties;
	}
	
}
