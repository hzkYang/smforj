package com.smforj.ssm.sys.web.service.impl;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smforj.ssm.encrypt.md5.MD5;
import com.smforj.ssm.sys.restful.domain.UserCache;
import com.smforj.ssm.sys.restful.service.impl.UserServiceImpl;
import com.smforj.ssm.sys.web.bean.SysUser;
import com.smforj.ssm.sys.web.dao.SysUserDao;
import com.smforj.ssm.sys.web.domain.IUser;
import com.smforj.ssm.sys.web.service.LoginService;
import com.smforj.ssm.util.DateFormat;

@Service
public class LoginServiceImpl extends UserServiceImpl implements LoginService {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public IUser getUser(String username, String password) { 
		log.debug(String.format("getUser username : %spassword :%s",username,password));
		SysUser query = new SysUser();
		query.setUsername(username);
		query.setPassword(MD5.getMd5(password));
		return sysUserDao.selectOne(query);
	}
	
	@Override
	public UserCache login(String username, String password, String ip) { 
		IUser user = this.getUser(username, password); 
		if (user != null) {// 验证成功
			Timestamp time = new Timestamp(System.currentTimeMillis());
			user.set("last_login_ip", ip);
			user.set("last_login_time", time); 
			user.update();
			UserCache usercache = this.addUser(user, DateFormat.dateToString(time, "yyyy-MM-dd HH:mm:ss"));  
			return usercache;
		}
		return null;
	} 
	@Override
	public void logout(String sessionid) { 
		this.removeUser(sessionid);
	}

}
