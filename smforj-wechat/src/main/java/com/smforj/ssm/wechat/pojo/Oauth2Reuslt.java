package com.smforj.ssm.wechat.pojo;

import java.io.Serializable;

/****
 * 授权凭证 返回类型
 * 
 * @author Haijun Gao 
 * @date 2016-8-16 下午5:49:11
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public class Oauth2Reuslt implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2207594570728331835L;
	private Integer errcode;
	private String errmsg;
	public Integer getErrcode() {
		return errcode;
	}
	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	} 
}
