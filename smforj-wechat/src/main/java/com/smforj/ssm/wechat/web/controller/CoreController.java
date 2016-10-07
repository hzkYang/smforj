package com.smforj.ssm.wechat.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;

/***
 * 注解形式打开连接
 * 
 * @author Haijun Gao 
 * @date 2016-7-27 上午9:39:42
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public interface CoreController { 
	
	/***
	 * get 方法
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @date 2016-7-27 上午9:40:06
	 */
	public void coreGet(HttpServletRequest request,
			HttpServletResponse response,@PathVariable String pid) throws Exception;
	/***
	 * set 方法
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @date 2016-7-27 上午9:40:06
	 */
	public void corePost(HttpServletRequest request,
			HttpServletResponse response,@PathVariable String pid)throws Exception; 

}
