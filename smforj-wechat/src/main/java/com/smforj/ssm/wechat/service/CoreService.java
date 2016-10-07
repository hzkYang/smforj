package com.smforj.ssm.wechat.service;


/**
 * 处理微信发来的信息
 * 公共接口
 * @author SMFORJ
 *
 */
public interface CoreService {

	/***
	 * 处理消息
	 * @param msg 微信发过来的消息
	 * @return 处理后的消息
	 * @date 2016-8-2 下午3:23:53
	 */
	public String processRequest(String msg);

}
