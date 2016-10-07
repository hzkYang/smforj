package com.smforj.ssm.frame.core.web.controller;


/***
 * 基础控制器接口
 * 
 * @author Haijun Gao 
 * @date 2016-7-22 下午4:53:56
 * @param <T>
 * @param <Q>
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public interface BaseControllerSupport{ 
	
	/***
	 * 获取路径
	 * @return
	 * @date 2016-8-11 下午1:48:35
	 */
	public String getViewPath();
	
	
	/***
	 * 获取路径
	 * @return
	 * @date 2016-8-11 下午1:48:35
	 */
	public String getViewPath(String view);
	
	
	/**
	 * 获取删除返回路径,默认重定向到列表页面
	 * @return
	 */
	public String getRedirectPath();
	
	
	/**
	 * 获取删除返回路径,默认重定向到列表页面
	 * @return
	 */
	public String getRedirectPath(String view);
}
