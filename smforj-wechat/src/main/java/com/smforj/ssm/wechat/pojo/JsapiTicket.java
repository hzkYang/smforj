package com.smforj.ssm.wechat.pojo;

import java.io.Serializable;

/***
 * jsapi_ticket 对象
 * 
 * @author Haijun Gao 
 * @date 2016-8-22 上午9:46:44
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public class JsapiTicket implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1381386459444759187L;
	/***
	 * {
	 * 	"errcode":0,
	 * 	"errmsg":"ok",
	 * 	"ticket":"bxLdikRXVbTPdHSM05e5u5sUoXNKd8-41ZO3MhKoyN5OfkWITDGgnr2fwJ0m9E8NYzWKVZvdVtaUgWvsdshFKA",
	 * 	"expires_in":7200
	 * 	}
	 */
	private int errcode;
	private String errmsg;
	private String ticket;
	private String expires_in;
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	} 
	
}
