package com.smforj.ssm.wechat.web.controller;

import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.smforj.ssm.wechat.pojo.AccessToken;
import com.smforj.ssm.wechat.pojo.UserInfo;
 
/***
 * OAuth2 接口
 * 
 * @author Haijun Gao 
 * @date 2016-7-27 下午5:37:06
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public interface OAuth2Controller {
	/**
	 * 构造参数并将请求重定向到微信API获取登录信息
	 * 
	 * @param index
	 * @return
	 */ 
	public String Oauth2API(HttpServletRequest request, @RequestParam String resultUrl,@PathVariable("cid") String cid);

	/**
	 * 根据code获取Userid后跳转到需要带用户信息的最终页面
	 * 
	 * @param request
	 * @param code
	 *            获取微信重定向到自己设置的URL中code参数
	 * @param oauth2url
	 *            跳转到最终页面的地址
	 * @return
	 */ 
	public String Oauth2MeUrl(HttpServletRequest request,HttpServletResponse response, @RequestParam String code, 
			@RequestParam String oauth2url,@PathVariable("cid") String cid); 

	/**
	 * 调用接口获取用户信息
	 * 
	 * @param token
	 * @param code
	 * @param agentId
	 * @return
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public String getMemberGuidByCode(String token, String code, int agentId);
	
	
	/**
	 * 调用接口获取用户信息
	 * 
	 * @param token 
	 * @param openId
	 * @return
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public UserInfo getMember(AccessToken accessToken);

}
