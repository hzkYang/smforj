package com.smforj.ssm.frame.core.enums;

/***
 * 系统配置信息接口
 * 
 * @author Haijun Gao 
 * @date 2016-9-9 下午2:04:59
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public interface FjSystem {
	
	/***
	 * 获取默认前台模板
	 * @return 前台模板名称
	 * @date 2016-9-9 下午2:06:06
	 */
	public String getDefaultFrontTemplete();
	
	/***
	 * 获取默认后台模板
	 * @return 后台模板名称
	 * @date 2016-9-9 下午2:06:27
	 */
	public String getDefaultAdminTemplete();

}
