package com.smforj.ssm.wechat.util;

import net.sf.json.JSONObject;

import com.smforj.ssm.wechat.pojo.AccessToken;
import com.smforj.ssm.wechat.pojo.UserInfo;

/**
 * 微信企业号调用类 {"errcode":0,"errmsg":"ok"} 此结果表示调用方法成功返回
 * 
 * @author Sunlight
 * 
 */
public class FuWuUtil {
	/**
	 * 获取企业号AccessToken
	 * 
	 * @param CorpID
	 * @param CorpSecret
	 * @return
	 */
	public static AccessToken getAccessToken(String CorpID, String CorpSecret,String code) {
		AccessToken accessToken = AccessTokenUtil.getAccessToken(CorpID,
				CorpSecret, code);
		return accessToken;
	}

	/**
	 * OAuth2验证接口根据code获取成员信息
	 * 
	 * @param access_token
	 * @param code
	 * @param AgentID
	 * @return
	 */
	public static Result<UserInfo> oAuth2GetUser(String access_token, String openId) {
		Result<UserInfo> result = new Result<UserInfo>();
		JSONObject jsonObject = OAuth2Util.getUser(access_token, openId);
		if (jsonObject != null) {
			try { 
				if(!jsonObject.containsKey("errcode")) 
				{
					UserInfo user = (UserInfo) JSONObject.toBean(jsonObject, UserInfo.class);
					result.setErrmsg("");
					result.setErrcode("0");
					result.setObj(user);
				} else {
					result.setErrmsg(jsonObject.getString("errmsg"));
					result.setErrcode(jsonObject.getString("errcode"));
				}

			} catch (Exception e) {
				result.setErrmsg("accessToken 超时......");
				result.setErrcode("42001");
			}
		}
		return result;
	}
}
