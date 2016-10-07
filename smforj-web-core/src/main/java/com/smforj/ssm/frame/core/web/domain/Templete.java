package com.smforj.ssm.frame.core.web.domain;

import com.smforj.ssm.frame.core.enums.ITemplete;

/***
 * 模板对象
 * 
 * @author Haijun Gao 
 * @date 2016-8-11 下午4:58:41
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public class Templete implements ITemplete {  
	/***
	 * 前台模板
	 */
	private String default_templete;

	public String getDefault_templete() {
		return default_templete;
	}

	public void setDefault_templete(String default_templete) {
		this.default_templete = default_templete;
	}

	@Override
	public String getTemplete() { 
		return default_templete == null ? "" : default_templete;
	}

	@Override
	public void setTemplete(String templete) { 
		this.default_templete = templete;
	}  
}
