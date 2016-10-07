package com.smforj.ssm.sys.restful.service; 

import com.smforj.ssm.sys.restful.domain.UserCache;
import com.smforj.ssm.sys.web.domain.IUser;

/***
 * 用户service 主要是使用于登陆等
 * 
 * @author Haijun Gao 
 * @date 2016-9-6 上午10:51:49
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public interface UserService {
	
	/***
	 * 添加用户到cache
	 * @param user
	 * @param sessionid
	 * @return
	 * @date 2016-9-6 下午6:02:43
	 */
	public UserCache addUser(IUser user, String sessionid);
	
	/***
	 * 删除用户从cache
	 * @param sessionid
	 * @date 2016-9-6 下午6:03:11
	 */
	public void removeUser(String sessionid);
	
	/***
	 * 获取user
	 * @param sessionid
	 * @return
	 * @date 2016-9-6 下午6:03:59
	 */
	public IUser getUser(String sessionid);
	
	/***
	 * 根据用户名称获取sessionid
	 * @param username 用户名称
	 * @return sessionid
	 * @date 2016-9-6 下午6:04:19
	 */
	public String getSessionId(String username);
	
	
	/**
	 * 用户缓存信息
	 * 
	 * @return
	 */
	public UserCache getUserCache(String sessionid); 
	
	/**
	 * 用户是否存在，(等同于用户是否登陆)
	 * 
	 * @return
	 */
	public boolean hasUser(String sessionid); 


}
