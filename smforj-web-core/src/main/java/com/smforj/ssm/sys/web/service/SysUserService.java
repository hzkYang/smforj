package com.smforj.ssm.sys.web.service;

import com.smforj.ssm.frame.core.service.BaseService;
import com.smforj.ssm.sys.web.bean.SysUser;

/***
 * 用户基础接口
 * 
 * @author Haijun Gao 
 * @date 2016-9-8 上午10:15:11
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public interface SysUserService extends BaseService<SysUser> {

	/***
	 * 登陆
	 * @param username
	 * @param password
	 * @param ip
	 * @return
	 * @date 2016-9-8 上午10:46:17
	 */
	public SysUser getUser(String username,String password);
}
