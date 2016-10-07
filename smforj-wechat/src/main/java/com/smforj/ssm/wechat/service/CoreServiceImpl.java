package com.smforj.ssm.wechat.service;

import java.util.Date;
import java.util.Map;

import com.smforj.ssm.wechat.pojo.resp.TextMessage;
import com.smforj.ssm.wechat.util.MessageUtil;

/***
 * 处理微信发来的信息 事例类
 * 
 * @author Haijun Gao 
 * @date 2016-8-6 下午1:19:44
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public abstract class CoreServiceImpl implements CoreService {
	
	private Map<String, String> requestMap = null;
 
	/***
	 * 获取消息Map
	 * @return
	 * @date 2016-8-2 下午3:39:36
	 */
	public Map<String, String> getRequestMap() {
		return requestMap;
	} 
	
	/***
	 * 处理文本消息 
	 * @return
	 * @date 2016-8-6 下午1:18:30
	 */
	public abstract String doText();
	public abstract String doImage();
	public abstract String doLocation(); 
	public abstract String doLink();
	public abstract String doEvent(); 
	public abstract String doVoice();
	
	/***
	 * 检测操作权限 如果不知道权限就返回 ture
	 * @return 有相应的权限 true 没有则 false
	 * @date 2016-8-2 下午3:54:35
	 */
	public abstract Boolean checkPrem();
	
	
	public String processRequest(String msg) {
		String respMessage = null; 
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！"; 
			// xml请求解析
			requestMap = MessageUtil.parseXml(msg);

			System.out.println("MsgType=="+requestMap.get("MsgType")); 
			System.out.println("Event=="+requestMap.get("Event")); 
			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			
			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			if(checkPrem())
			{ 
				// 文本消息
				if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
					respContent = doText(); 
				}
				// 图片消息
				else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
					respContent = doImage(); 
				}
				// 地理位置消息
				else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
					respContent = doLocation(); 
				}
				// 链接消息
				else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
					respContent = doLink(); 
				}
				// 音频消息
				else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
					respContent = doVoice(); 
				}
				// 事件推送
				else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) { 
					respContent = doEvent();
				}
			}else
			{
				textMessage.setContent("非法用户");
			}

			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			respMessage="有异常了。。。";
		}
		return respMessage;
	} 

}
