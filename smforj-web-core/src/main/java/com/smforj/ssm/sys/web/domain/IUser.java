package com.smforj.ssm.sys.web.domain;


/****
 * 用户接口
 * 
 * @author Haijun Gao 
 * @date 2016-9-6 上午10:56:01
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public interface IUser {

	/**
	 * 用户登录名称
	 * @return
	 */
	String getUsername();
	
	/**
	 * 用户id号
	 * @return
	 */
	Integer getUid();
	
	/**
	 * UUID
	 * @return
	 */
	String getUUID();   
	
	/***
	 * 设置参数
	 * @param key
	 * @param value
	 * @date 2016-9-7 上午9:18:24
	 */
	void set(String key,Object value); 
	
	/***
	 * 更新参数信息
	 * 
	 * @date 2016-9-7 上午9:19:23
	 */
	void update(); 
}
