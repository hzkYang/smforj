package com.smforj.ssm.wechat.web.controller.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smforj.ssm.util.StringEx;
import com.smforj.ssm.wechat.aes.AesException;
import com.smforj.ssm.wechat.aes.WXBizMsgCrypt;
import com.smforj.ssm.wechat.aes.WXBizMsgCryptImpl;
import com.smforj.ssm.wechat.service.CoreService;
import com.smforj.ssm.wechat.util.Constants;
import com.smforj.ssm.wechat.web.controller.CoreController;


/***
 * 注解方式打开链接
 * 
 * @author Haijun Gao 
 * @date 2016-7-27 上午9:49:02
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */ 
public abstract class CoreControllerImpl implements CoreController{  
	
	private Logger log = LogManager.getLogger(this.getClass()); 
	
	@Autowired
	private CoreService coreService; 
	
	private String token = Constants.TOKEN; 
	private String encodingAESKey =Constants.encodingAESKey;
	private String appId = Constants.APPID; 


	/****
	 * 无加密传送方式
	 */
	@RequestMapping(value = { "/core/{pid}" }, method = RequestMethod.GET)
	@Override
	public void coreGet(HttpServletRequest request,
			HttpServletResponse response,@PathVariable String pid) throws IOException{
		
		log.info("CoreControllerImpl coreGet start"); 
		// 微信加密签名
		String msg_signature = request.getParameter("msg_signature");
		log.info("msg_signature: "+ msg_signature);
		// 微信加密签名
		String signature = request.getParameter("signature"); 
		log.info("signature: "+ signature);    
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		log.info("timestamp: "+ timestamp);
		// 随机数
		String nonce = request.getParameter("nonce");
		log.info("nonce: "+ nonce);
		// 随机字符串
		String echostr = request.getParameter("echostr");
		log.info("echostr: "+ echostr);

		System.out.println("request=" + request.getRequestURL());
 
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		String result = null;
		try { 
			WXBizMsgCrypt wxcpt = new WXBizMsgCryptImpl(token, encodingAESKey,
					appId);
			result = wxcpt.verifyURL(signature, timestamp, nonce, echostr);
		} catch (AesException e) {
			e.printStackTrace();
		}
		if (result == null) {
			result = token;
		} 
		// 响应消息
		printWrite(response,result); 
		
		log.info("CoreControllerImpl coreGet end");
	}


	@RequestMapping(value = { "/core/{pid}" }, method = RequestMethod.POST)
	@Override
	public void corePost(HttpServletRequest request,
			HttpServletResponse response,@PathVariable String pid) throws Exception{
		log.info("CoreControllerImpl corePost start");
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String resultMsg = ""; 
		if(checkPid(pid))
		{
			// 微信加密签名
			String msg_signature = request.getParameter("msg_signature");
			log.info("msg_signature======= "+ msg_signature);
			// 微信加密签名
			String signature = request.getParameter("signature");
			log.info("signature======= "+ signature);
			// 时间戳
			String timestamp = request.getParameter("timestamp");
			log.info("timestamp======= "+ timestamp);
			// 随机数
			String nonce = request.getParameter("nonce");
			log.info("nonce======= "+ nonce); 
			//从请求中读取整个post数据
			InputStream inputStream = request.getInputStream();
			String postData = IOUtils.toString(inputStream, Constants.DefaultEncoding);
			System.out.println("postData======= "+postData);
			
			String msg = "";
			WXBizMsgCryptImpl wxcpt = null;
			try {
				wxcpt = new WXBizMsgCryptImpl(token, encodingAESKey, appId);
				//解密消息
				msg = wxcpt.decryptMsg(msg_signature, timestamp, nonce, postData);
			} catch (AesException e) {
				log.error("WXBizMsgCryptFw DecryptMsg error :" +e.getMessage());
				//e.printStackTrace();
			}
			System.out.println("DecryptMsg response msg======= " + msg); 
			// 调用核心业务类接收消息、处理消息
			String respMessage = coreService.processRequest(msg);
			System.out.println("respMessage=======" + respMessage);  
			try {
				//加密回复消息
				resultMsg = wxcpt.encryptMsg(respMessage, timestamp, nonce);
			} catch (AesException e) {
				log.error("WXBizMsgCryptFw EncryptMsg error :" +e.getMessage());
				//e.printStackTrace();
			} 
		}
		System.out.println("EncryptMsg response encryptMsg======= " + resultMsg); 
		// 响应消息
		printWrite(response,resultMsg);
		log.info("CoreControllerImpl corePost end");
	}
	
	/****
	 * 检测pid的正确性
	 * @param pid
	 * @return
	 * @date 2016-8-23 下午5:24:24
	 */
	private boolean checkPid(String pid)
	{
		if(StringEx.isExEmpty(pid))
			return false;
		return true;
	} 
	
	/***
	 * 回写
	 * @param response 返回的response
	 * @param respMsg 返回的消息
	 * @date 2016-7-27 上午9:48:02
	 */
	private void printWrite(HttpServletResponse response,String respMsg)
	{
		// 响应消息
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(respMsg);
		} catch (IOException e) { 
			e.printStackTrace();
		}finally
		{
			out.close();
			out = null;
		}  
	} 
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEncodingAESKey() {
		return encodingAESKey;
	}

	public void setEncodingAESKey(String encodingAESKey) {
		this.encodingAESKey = encodingAESKey;
	} 
	
	public String getAppId() {
		return appId;
	} 
	public void setAppId(String appId) {
		this.appId = appId;
	}

}
