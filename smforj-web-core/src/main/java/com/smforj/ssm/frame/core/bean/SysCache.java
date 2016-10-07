package com.smforj.ssm.frame.core.bean;

import com.smforj.ssm.frame.core.enums.FjSystem;
import com.smforj.ssm.frame.core.enums.ITemplete;
import com.smforj.ssm.frame.core.web.domain.Templete;

/***
 * 系统全局变量信息
 * 
 * @author Haijun Gao 
 * @date 2016-9-9 下午2:07:38
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public class SysCache {
	
	private static FjSystem sys;
	private static ITemplete templete;

	public static FjSystem getSys() {
		return sys == null ? sys = new FjSystem() { 
			@Override
			public String getDefaultFrontTemplete() { 
				return "ma";
			}
			
			@Override
			public String getDefaultAdminTemplete() { 
				return "ssr";
			}
		} : sys;
	}

	public static void setSys(FjSystem sys) {
		SysCache.sys = sys;
	} 

	/***
	 * 获取模板信息
	 * @return
	 * @date 2016-9-9 下午2:43:05
	 */
	public static ITemplete getTemplete() {
		return templete == null ? templete = new Templete() : templete;
	}

	/***
	 * 设置模板信息
	 * @param templete
	 * @date 2016-9-9 下午2:43:17
	 */
	public static void setTemplete(ITemplete templete) {
		SysCache.templete = templete;
	}  

}
