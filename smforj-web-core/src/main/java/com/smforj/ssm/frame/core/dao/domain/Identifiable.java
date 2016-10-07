package com.smforj.ssm.frame.core.dao.domain;

import java.io.Serializable;

/***
 * 主键标识
 * 
 * @author Haijun Gao 
 * @date 2016-7-31 上午10:27:19
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public interface Identifiable extends Serializable {
	/**
	 * 获取主键
	 * @author Haijun Gao
	 * @return
	 * @date 2014年3月3日下午5:56:13
	 */
	public String getId();

	/**
	 * 设置ID属性
	 * @param id
	 */
	public void setId(String id);
}
