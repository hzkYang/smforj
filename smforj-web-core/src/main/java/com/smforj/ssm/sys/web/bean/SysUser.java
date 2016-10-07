package com.smforj.ssm.sys.web.bean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.smforj.ssm.frame.core.bean.PageBean;
import com.smforj.ssm.sys.web.domain.IUser;

/***
 * User 用户对象 包含reader and manager
 * 
 * @author Haijun Gao 
 * @date 2016-7-31 上午10:23:56
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public class SysUser extends PageBean implements IUser{

	/**
	 * @fields serialVersionUID 
	 */
	private static final long serialVersionUID = 3660184499862071843L;

	/**
	 * @fields id 主键
	 */
	private Integer uid; 
	private String username;
	private String password;
	private String nickname; 
	private String wechat;
	private String phone;
	private String email; 
	private String remark;
	private String departid; 
	

	public Integer getUid() {
		return uid;
	} 
	public void setUid(Integer uid) {
		this.uid = uid;
	} 
	public String getUsername() {
		return username;
	} 
	public void setUsername(String username) {
		this.username = username;
	}  
	public String getPassword() {
		return password;
	} 
	public void setPassword(String password) {
		this.password = password;
	} 
	public String getNickname() {
		return nickname;
	} 
	public void setNickname(String nickname) {
		this.nickname = nickname;
	} 
	public String getWechat() {
		return wechat;
	} 
	public void setWechat(String wechat) {
		this.wechat = wechat;
	} 
	public String getPhone() {
		return phone;
	} 
	public void setPhone(String phone) {
		this.phone = phone;
	} 
	public String getEmail() {
		return email;
	} 
	public void setEmail(String email) {
		this.email = email;
	} 
	public String getRemark() {
		return remark;
	} 
	public void setRemark(String remark) {
		this.remark = remark;
	}  
	public String getDepartid() {
		return departid;
	} 
	public void setDepartid(String departid) {
		this.departid = departid;
	} 
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	} 
	@Override
	public String getUUID() { 
		return this.uuid;
	}
	
	private Map<String,Object> map = new HashMap<String,Object>(); 
	@Override
	public void set(String key, Object value) {  
		if(!map.containsKey(key))
			map.put(key, value);
	}
	@Override
	public void update() { 
		
	} 
}
