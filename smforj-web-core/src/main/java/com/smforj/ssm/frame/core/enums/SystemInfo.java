package com.smforj.ssm.frame.core.enums;

/***
 * 系统配置实现对象
 * 
 * @author Haijun Gao 
 * @date 2016-9-9 下午2:17:03
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public class SystemInfo implements FjSystem {
	
	private String defaultFrontTemplete;
	private String defaultAdminTemplete;

	@Override
	public String getDefaultFrontTemplete() { 
		return defaultFrontTemplete;
	}

	@Override
	public String getDefaultAdminTemplete() { 
		return defaultAdminTemplete;
	}

	public void setDefaultFrontTemplete(String defaultFrontTemplete) {
		this.defaultFrontTemplete = defaultFrontTemplete;
	}

	public void setDefaultAdminTemplete(String defaultAdminTemplete) {
		this.defaultAdminTemplete = defaultAdminTemplete;
	}

}
