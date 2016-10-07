package com.smforj.ssm.wechat.web.controller.impl;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smforj.ssm.wechat.pojo.AccessToken;
import com.smforj.ssm.wechat.pojo.UserInfo;
import com.smforj.ssm.wechat.util.Constants;
import com.smforj.ssm.wechat.util.FuWuUtil;
import com.smforj.ssm.wechat.util.Result;
import com.smforj.ssm.wechat.web.controller.OAuth2Controller;
 
/***
 * OAuth2 只针对服务号实现类
 * 
 * @author Haijun Gao 
 * @date 2016-7-27 下午5:38:38
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public abstract class OAuth2ControllerFwImpl implements OAuth2Controller { 
	
	/**
	 * 构造参数并将请求重定向到微信API获取登录信息
	 * 
	 * @param index
	 * @return
	 */
	@RequestMapping(value = { "/oauth2fw/{cid}" })
	public String Oauth2API(HttpServletRequest request, @RequestParam String resultUrl,@PathVariable("cid") String cid) {  
		String appId = Constants.APPID;
		String redirectUrl = "";
		if (resultUrl != null && 
				(cid != null && cid != "")) {
			//String reqUrl =request.getServerName()+ request.getRequestURI(); 
			//去除本连接
			String reqUrl = request.getRequestURL().toString().replace("oauth2fw", "oauth2fwurl");
			String backUrl =reqUrl + "?oauth2url=" + resultUrl;
			System.out.println("backUrl=========="+backUrl);
			redirectUrl = oAuth2Url(appId, backUrl,"snsapi_base");
		}
		System.out.println("redirectUrl=========="+redirectUrl);
		return "redirect:" + redirectUrl;
	}
	
	/**
	 * 构造参数并将请求重定向到微信API获取登录信息
	 * 
	 * @param index
	 * @return
	 */
	@RequestMapping(value = { "/oauth2/{cid}" })
	public String Oauth2(HttpServletRequest request, @RequestParam String resultUrl,@PathVariable("cid") String cid) {  
		String appId = Constants.APPID;
		String redirectUrl = "";
		if (resultUrl != null && 
				(cid != null && cid != "")) { 
			//去除本连接
			String reqUrl = request.getRequestURL().toString().replace("oauth2fw", "oauth2fwurl");
			String backUrl =reqUrl + "?oauth2url=" + resultUrl;
			System.out.println("backUrl=========="+backUrl);
			redirectUrl = oAuth2Url(appId, backUrl,"snsapi_userinfo");
		}
		System.out.println("redirectUrl=========="+redirectUrl);
		return "redirect:" + redirectUrl;
	}

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
	@RequestMapping(value = { "/oauth2fwurl/{cid}"})
	public String Oauth2MeUrl(HttpServletRequest request,HttpServletResponse response, @RequestParam(required=false) String code, 
			@RequestParam String oauth2url,@PathVariable("cid") String cid) {  
		System.out.println("Oauth2MeUrl code=========="+code); 
		System.out.println("getAccessToken start=========="+System.currentTimeMillis());
		//获取token
		AccessToken accessToken = FuWuUtil.getAccessToken(Constants.APPID, Constants.AppSecret,code); 
		System.out.println("getAccessToken start=========="+System.currentTimeMillis());
		System.out.println("accessToken=========="+accessToken.getAccess_token());
		HttpSession session = request.getSession(); 
		// 这里简单处理,存储到session中 
		if (accessToken != null) {  
			session.setAttribute("openid", accessToken.getOpenid());    
		}   
		return "redirect:" + oauth2url; 
	}

	/**
	 * 构造带员工身份信息的URL
	 * 
	 * @param appid id
	 * @param redirect_uri
	 *            授权后重定向的回调链接地址，请使用urlencode对链接进行处理
	 * @param state
	 *            重定向后会带上state参数，企业可以填写a-zA-Z0-9的参数值
	 * @return
	 */
	private String oAuth2Url(String appid, String redirect_uri,String scope) {
		try {
			redirect_uri = java.net.URLEncoder.encode(redirect_uri, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		/**
		 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&
		 * response_type=code&scope=SCOPE&state=STATE#wechat_redirect
		 * **/
		String oauth2Url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appid + "&redirect_uri=" + redirect_uri
				+ "&response_type=code&scope="+scope+"&state=smforj#wechat_redirect"; 
		return oauth2Url;
	}

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
	public UserInfo getMember(AccessToken accessToken) {
		System.out.println( "\ntoken=" + accessToken.getAccess_token() + "\naopenid=" + accessToken.getOpenid());
		Result<UserInfo> result = FuWuUtil.oAuth2GetUser(accessToken.getAccess_token(), accessToken.getOpenid());
		System.out.println("result=" + result);
		if (result.getErrcode() == "0") {
			if (result.getObj() != null) {
				// 此处可以通过微信授权用code还钱的Userid查询自己本地服务器中的数据
				return result.getObj();
			}
		}
		return null;
	}
	
	@Override
	public String getMemberGuidByCode(String token, String code, int agentId) { 
		throw new NotImplementedException();
	}  

}
