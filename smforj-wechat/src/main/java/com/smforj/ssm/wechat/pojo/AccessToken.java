package com.smforj.ssm.wechat.pojo;

import java.io.Serializable;

/****
 * AccessToken
 * 
 * 
 * @author Haijun Gao 
 * @date 2016-8-16 上午11:44:06
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public class AccessToken implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2872201274794471722L;
	/****
	 *    "access_token":"ACCESS_TOKEN",
	 *    "expires_in":7200,
	 *    "refresh_token":"REFRESH_TOKEN",
	 *    "openid":"OPENID",
	 *    "scope":"SCOPE",
	 *    "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
	 */
    // 获取到的凭证  
    private String access_token;  
    // 凭证有效时间，单位：秒  
    private int expiresIn;  
    
    
    private String refresh_token;
    private String openid;
    private String scope;
    private String unionid; 
    
    
  
    public int getExpiresIn() {  
        return expiresIn;  
    }  
  
    public void setExpiresIn(int expiresIn) {  
        this.expiresIn = expiresIn;  
    }

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	} 
    
    
}
