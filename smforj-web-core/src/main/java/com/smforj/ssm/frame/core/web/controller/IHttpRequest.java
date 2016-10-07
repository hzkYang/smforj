/****
 * 用于http request response 对象的传输，针对spring mvc 模式
 * 
 * 
 * 
 */
package com.smforj.ssm.frame.core.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IHttpRequest {

	/***
	 * 设置controller request and response
	 * @param request
	 * @param response
	 * @date 2016-9-8 下午1:48:43
	 */
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response);
}
