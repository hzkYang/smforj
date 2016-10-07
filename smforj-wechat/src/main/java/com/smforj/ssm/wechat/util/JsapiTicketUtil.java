package com.smforj.ssm.wechat.util;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.smforj.ssm.wechat.enums.EnumMethod;
import com.smforj.ssm.wechat.pojo.JsapiTicket;

/***
 * jsapi_ticket是公众号用于调用微信JS接口的临时票据。正常情况下，
 * jsapi_ticket的有效期为7200秒，通过access_token来获取。
 * 由于获取jsapi_ticket的api调用次数非常有限，频繁刷新jsapi_ticket会导致api调用受限，
 * 影响自身业务，开发者必须在自己的服务全局缓存jsapi_ticket
 * 
 * @author Haijun Gao 
 * @date 2016-8-22 上午9:44:57
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public class JsapiTicketUtil {

	/****
	 * 微信服务号ticket地址
	 */
	private static final String FWJSAPITICKETGET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	
	/***
	 * 获取jsapi ticket
	 * @param access_token access token 
	 * @return
	 * @date 2016-8-22 上午9:51:57
	 */
	public static JsapiTicket getJsapiTicket(String access_token)
	{
		String url = FWJSAPITICKETGET.replace("ACCESS_TOKEN", access_token);
		return getJsapiTicket(access_token,url);
	}
	/***
	 * 获取jsapi ticket
	 * @param access_token access token
	 * @param url 微信地址
	 * @return
	 * @date 2016-8-22 上午9:51:57
	 */
	public static JsapiTicket getJsapiTicket(String access_token,String url)
	{
		JsapiTicket jsapiTicket = null;
		JSONObject jsonObject = HttpRequestUtil.httpRequest(url, EnumMethod.GET.name(), null);
		if(jsonObject==null){
			jsonObject = HttpRequestUtil.httpRequest(url, EnumMethod.GET.name(), null);
		}
		// 如果请求成功
		if (null != jsonObject) {
			try {    
				 jsapiTicket = (JsapiTicket) JSONObject.toBean(jsonObject, JsapiTicket.class); 
			} catch (JSONException e) {
				jsapiTicket = null;
				// 获取token失败
				System.out.println("获取jsapiTicket失败："+e.getMessage());
			}
		}
		return jsapiTicket;
	}
	
	
	public static void main(String[] args)
	{
		Map<String,String> map = new HashMap<String, String>();
		map.put("id", "1");
		map.put("name", "ghj"); 
		
		String str = JSONObject.fromObject(map).toString();
		System.out.println("str: "+str);
		JSONObject json = JSONObject.fromObject(str); 
		System.out.println("json: "+json);  
		System.out.println(json.get("id"));
		System.out.println(json.get("name"));
	}
	
	
}
