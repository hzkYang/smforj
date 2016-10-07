package com.smforj.ssm.sys.web.bean.query;

import com.smforj.ssm.sys.web.bean.SysUser;

/***
 * User 用户对象 包含reader and manager
 * 
 * @author Haijun Gao 
 * @date 2016-7-31 上午10:23:56
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public class SysUserQuery extends SysUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6969926853954545221L;
	
	/***
	 * 模糊查询
	 */
	private String userNameLike;


	public String getUserNameLike() {
		return userNameLike;
	}


	public void setUserNameLike(String userNameLike) {
		this.userNameLike = userNameLike;
	}

	 
}
