package com.smforj.ssm.sys.web.service;

import com.smforj.ssm.sys.restful.domain.UserCache;


/***
 * 登陆service
 * 
 * @author Haijun Gao 
 * @date 2016-9-9 下午3:46:47
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public interface LoginService { 
		
	/***
	 * 退出登陆
	 * @param sessionid
	 * @date 2016-9-9 下午3:48:31
	 */
	public void logout(String sessionid);
	
	/**
	 * 登陆
	 * @param username 用户名
	 * @param password 密码
	 * @param ip ip
	 * @return 登陆成功则返回 UserCache 否则返回 null
	 */
	public UserCache login(String username, String password, String ip);
	
	 

}
