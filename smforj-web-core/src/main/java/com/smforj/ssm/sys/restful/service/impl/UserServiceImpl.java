package com.smforj.ssm.sys.restful.service.impl; 

import com.smforj.ssm.frame.core.plugin.CachePlugin;
import com.smforj.ssm.sys.restful.domain.UserCache;
import com.smforj.ssm.sys.restful.service.UserService;
import com.smforj.ssm.sys.web.domain.IUser;
import com.smforj.ssm.util.StringEx;

public abstract class UserServiceImpl implements UserService {
	private static final String CACHESESSION = "ehCacheSession";

	@Override
	public UserCache addUser(IUser user, String sessionid) {
		String oldsessionid = CachePlugin.get(CACHESESSION, user.getUsername());
		if (!StringEx.isExEmpty(oldsessionid)) {
			removeUser(oldsessionid);
		}
		UserCache usercache = new UserCache(user);
		// 保存uset
		CachePlugin.put(CACHESESSION, sessionid, usercache);
		// 保存session
		CachePlugin.put(CACHESESSION, user.getUsername(), sessionid);
		return usercache; 
	}

	@Override
	public void removeUser(String sessionid) {
		// 移除session
		IUser user = getUser(sessionid);
		if (user != null) {
			CachePlugin.remove(CACHESESSION, user.getUsername());
		}
		// 移除user
		CachePlugin.remove(CACHESESSION, sessionid); 
	}

	@Override
	public IUser getUser(String sessionid) {
		UserCache uc = getUserCache(sessionid);
		if (uc != null)
			return uc.getUser();
		return null;
	}

	@Override
	public String getSessionId(String username) {
		String oldsessionid = CachePlugin.get(CACHESESSION, username);
		if (!StringEx.isExEmpty(oldsessionid)) {
			return oldsessionid;
		}
		return null;
	}

	@Override
	public UserCache getUserCache(String sessionid) {
		return CachePlugin.get(CACHESESSION, sessionid);
	}

	@Override
	public boolean hasUser(String sessionid) {
		IUser user = getUser(sessionid);
		if (user == null) {
			return false;
		}
		System.out.println("hasUser info : the user is " + user.getUsername());
		String session_id = CachePlugin.get("ehCacheSession", user.getUsername());
		if (!StringEx.isExEmpty(session_id) && !session_id.equals(sessionid)) {
			return false;
		}
		return true;
	} 
	
	/***
	 * 获取用户信息
	 * @param username 用户名
	 * @param password 密码
	 * @return IUser 对象或null
	 * @date 2016-9-7 上午9:23:10
	 */
	public abstract IUser getUser(String username,String password);

}
