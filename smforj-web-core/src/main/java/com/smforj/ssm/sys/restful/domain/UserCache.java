package com.smforj.ssm.sys.restful.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.smforj.ssm.sys.web.domain.IUser;

public class UserCache implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1807371433833181263L;
	
	private IUser user = null;
	private Map<String, Object> info = null;
	
	public UserCache(IUser u) {
		setUser(u);
		info = new HashMap<String, Object>();
	}
	
	public void put(String key, Object value) {
		info.put(key, value);
	}
	
	public Object get(String key) {
		return info.get(key);
	}

	public Map<String, Object> getInfo() {
		return info;
	}

	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}

	public IUser getUser() {
		return user;
	}

	public void setUser(IUser user) {
		this.user = user;
	}
}
