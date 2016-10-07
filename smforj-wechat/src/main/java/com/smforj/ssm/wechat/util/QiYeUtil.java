package com.smforj.ssm.wechat.util;

import net.sf.json.JSONObject;

import com.smforj.ssm.wechat.pojo.AccessToken;

/**
 * 微信企业号调用类 {"errcode":0,"errmsg":"ok"} 此结果表示调用方法成功返回
 * 
 * @author Sunlight
 * 
 */
public class QiYeUtil {
	/**
	 * 获取企业号AccessToken
	 * 
	 * @param CorpID
	 * @param CorpSecret
	 * @return
	 */
	public static AccessToken getAccessToken(String CorpID, String CorpSecret) {
		AccessToken accessToken = AccessTokenUtil.getAccessToken(CorpID,
				CorpSecret, 1);
		return accessToken;
	}

	/**
	 * OAuth2验证接口根据code获取成员信息
	 * 
	 * @param token
	 * @param code
	 * @param AgentID
	 * @return
	 */
	public static Result<String> oAuth2GetUserByCode(String token, String code,
			int AgentID) {
		Result<String> result = new Result<String>();
		JSONObject jo = OAuth2Util.getUserByCode(token, code, AgentID,1);
		if (jo != null) {
			try {
				String userId = jo.getString("UserId");
				if (userId != null && userId.length() > 0) {
					result.setErrmsg("");
					result.setErrcode("0");
					result.setObj(userId);
				} else {
					result.setErrmsg(jo.getString("errmsg"));
					result.setErrcode(jo.getString("errcode"));
				}

			} catch (Exception e) {
				result.setErrmsg("accessToken 超时......");
				result.setErrcode("42001");
			}
		}
		return result;
	}
}
