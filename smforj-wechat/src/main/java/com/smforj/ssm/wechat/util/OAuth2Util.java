package com.smforj.ssm.wechat.util;

import com.smforj.ssm.wechat.enums.EnumMethod;
import com.smforj.ssm.wechat.pojo.Oauth2Reuslt;

import net.sf.json.JSONObject;

public class OAuth2Util { 
	/***
	 * 企业号地址
	 */
	private static final String get_oauth2_urlQy = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=ACCESS_TOKEN&code=CODE&agentid=AGENTID";

	/***
	 * 服务号地址
	 */
	private static final String get_oauth2_urlFw = "https://api.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=ACCESS_TOKEN&code=CODE&agentid=AGENTID";
	
	/***
	 * 根据 access token 获取用户信息
	 */
	private static final String get_oauth2_userinfo = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	
	/***
	 * 检测授权是否有有效
	 */
	private static final String get_oauth2_auth = "https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID";

	
	/**
	 * 根据access token  openid获取成员信息
	 * 
	 * @param access_token (授权界面的access_token与基础用户信息的access_token不一样)
	 * @param openId  
	 * @return 
	 */
	public static JSONObject getUser(String access_token, String openId) {
		//检验授权凭证（access_token）是否有效
		String menuUrl = get_oauth2_auth.replace("ACCESS_TOKEN", access_token).replace("OPENID", openId); 
		JSONObject jo = HttpRequestUtil.httpRequest(menuUrl, EnumMethod.GET.name(), null);
		Oauth2Reuslt result = (Oauth2Reuslt) JSONObject.toBean(jo,Oauth2Reuslt.class);
		System.out.println("Oauth2Reuslt result: " +result);
		if(null != result && result.getErrcode() == 0)
		{
			menuUrl = get_oauth2_userinfo.replace("ACCESS_TOKEN", access_token).replace("OPENID", openId); 
			jo = HttpRequestUtil.httpRequest(menuUrl, EnumMethod.GET.name(), null);
			System.out.println("jo=" + jo);
		}else
			jo = null;
		return jo;
	} 
	
	
	/**
	 * 根据code获取成员信息
	 * 
	 * @param token
	 * @param code
	 * @param AgentID
	 * @param type 0 服务 1企业
	 * @return
	 */
	public static JSONObject getUserByCode(String token, String code, int AgentID,int type) {
		String menuUrl = get_oauth2_urlFw.replace("ACCESS_TOKEN", token).replace("CODE", code).replace("AGENTID", AgentID + "");
		if(type == 1)
		   menuUrl = get_oauth2_urlQy.replace("ACCESS_TOKEN", token).replace("CODE", code).replace("AGENTID", AgentID + "");
		JSONObject jo = HttpRequestUtil.httpRequest(menuUrl, EnumMethod.GET.name(), null);
		System.out.println("jo=" + jo);
		return jo;
	} 

}
