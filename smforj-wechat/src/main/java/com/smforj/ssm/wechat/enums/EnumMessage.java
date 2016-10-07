package com.smforj.ssm.wechat.enums;

/***
 * 微信消息常量
 * 
 * @author Haijun Gao 
 * @date 2016-8-6 下午1:59:36
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public interface EnumMessage {
	/**
	 * 开发者微信号
	 */
	public String TOUSERNAME = "ToUserName";//	
	/***
	 * 发送方帐号（一个OpenID）
	 */
	public String FROMUSERNAME = "FromUserName";//	
	/***
	 * 消息创建时间 （整型）
	 */
	public String CREATETIME = "CreateTime";//	
	/***
	 * 消息类型
	 */
	public String MSGTYPE = "MsgType";//	
	/***
	 * 消息内容 
	 */
	public String CONTENT = "Content";//文本消息内容
	/***
	 * 消息id
	 */
	public String MSGID = "MsgId";//
	/***
	 * 事件类型，subscribe(订阅)、unsubscribe(取消订阅)
	 */
	public String EVENT = "Event";

}
