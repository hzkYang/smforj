package com.smforj.ssm.sys.web.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smforj.ssm.frame.core.service.BaseService;
import com.smforj.ssm.frame.core.web.controller.BaseControllerImpl;
import com.smforj.ssm.sys.web.bean.SysUser;
import com.smforj.ssm.sys.web.bean.vo.SysUserVo;
import com.smforj.ssm.sys.web.controller.UserController;
import com.smforj.ssm.sys.web.service.SysUserService;

/***
 * 系统用户实现类
 * 
 * @author Haijun Gao 
 * @date 2016-9-8 上午10:22:39
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */ 
@Controller
@RequestMapping(value={"/sys/user"})
public class UserControllerImpl extends BaseControllerImpl<SysUser, SysUserVo> implements UserController{

	@Autowired
	private SysUserService sysUserService;
	
	
	@Override
	protected BaseService<SysUser> getBaseService() { 
		return sysUserService;
	} 

}
