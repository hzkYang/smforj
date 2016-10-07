package com.smforj.ssm.wechat.util;

import net.sf.json.JSONObject;

import com.smforj.ssm.wechat.enums.EnumMethod;
import com.smforj.ssm.wechat.pojo.AccessToken;

/**
 * 公众平台通用接口工具类
 * 
 * 				
 *    "access_token":"ACCESS_TOKEN",
 *    "expires_in":7200,
 *    "refresh_token":"REFRESH_TOKEN",
 *    "openid":"OPENID",
 *    "scope":"SCOPE",
 *    "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
 *
 */
public class AccessTokenUtil {
	
	// 获取微信公众号：access_token的接口地址（GET） 限2000（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	// 根据code 等获取 access_token
	public final static String access_token_url_code = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	// 获取企业号access_token
	public final static String company_access_token_url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=CORPID&corpsecret=CORPSECRET";
	
	/**
	 * 获取access_token
	 * 
	 * @param appid
	 *            凭证
	 * @param appsecret
	 *            密钥
	 * @param type 1 企业号 0服务号
	 * @return
	 */
	public static AccessToken getAccessToken(String appid, String appsecret,String code) { 
		String requestUrl = access_token_url_code.replace("APPID", appid).replace("SECRET", appsecret).replace("CODE", code); 
		return getAccessToken(requestUrl);
	}
	/***
	 * 根据 url 获取 access_token
	 * @param requestUrl
	 * @return
	 * @date 2016-8-16 上午11:37:12
	 */
	private static AccessToken getAccessToken(String requestUrl)
	{
		AccessToken accessToken = null;
		JSONObject jsonObject = null;
		try{
			jsonObject = HttpRequestUtil.httpRequest(requestUrl, EnumMethod.GET.name(), null); 
			// 如果请求成功
			if (null != jsonObject) { 
				System.out.println("jsonObject: "+jsonObject.toString());  
				if(!jsonObject.containsKey("errcode")) 
					accessToken = (AccessToken) JSONObject.toBean(jsonObject, AccessToken.class);
				else
					accessToken = null; 
			}
		}catch(Exception ex)
		{
			// 获取token失败
			System.out.println("获取access_token_url_code失败："+ex.getMessage());
			jsonObject =null;
		} 
		return accessToken;
	}

	/**
	 * 获取access_token
	 * 
	 * @param appid
	 *            凭证
	 * @param appsecret
	 *            密钥
	 * @param type 1 企业号 0服务号
	 * @return
	 */
	public static AccessToken getAccessToken(String appid, String appsecret, int type) { 
		String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		if (type == 1) {
			requestUrl = company_access_token_url.replace("CORPID", appid).replace("CORPSECRET", appsecret);
			System.err.println(requestUrl);
		} 
		return getAccessToken(requestUrl);
	}
	
	public static void main(String[] agrs)
	{
		
		String code = "011mdmZ903bOSJ1qdqX908EiZ90mdmZG"; 
		System.out.println(System.currentTimeMillis());
		AccessToken acctoken = AccessTokenUtil.getAccessToken(Constants.APPID, Constants.AppSecret, code);
		System.out.println(System.currentTimeMillis());
		System.out.println(acctoken);
/*		String str = " {\"access_token\":\"Ce70J3wJHIZ-Jap_esn8XRyysYGd7mh-RUF-Ms2sF0c1a1fG1PP2ej5oI-mJwDAYujlaUQo8BeeqUQJM4XuIY3SIjPAwcO5ua4AHclzKCyg\"," +
				"\"expires_in\":7200," +
				"\"refresh_token\":\"qckxdnTinlzW__nTD-f-hFEjK77KSZZpiph5RecOkxWHnxiSZSicCe9vNBRHza6sFqdc2ft8CgN8FSRLJ0AOkWsSkmZeod5uZSJAIaSSPDE\"," +
				"\"openid\":\"opQSRwWhh9sCHQejRW4V8SlhkFNI\"," +
				"\"scope\":\"snsapi_base\"}";
		
		JSONObject jsonObject = JSONObject.fromObject(str);
		System.out.println(jsonObject);
		
		System.out.println(jsonObject.containsKey("errcode"));
		
		AccessToken accessToken = (AccessToken) JSONObject.toBean(jsonObject, AccessToken.class);
		
		System.out.println(accessToken.getAccess_token());*/
	}

}