package com.smforj.ssm.frame.core.dao;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/***
 * 动态数据源
 * 
 * @author Haijun Gao 
 * @date 2016-8-5 下午5:14:29
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public class DynamicDataSource extends AbstractRoutingDataSource  {

	/***
	 * 获取当前数据源信息
	 */
	@Override
	protected Object determineCurrentLookupKey() { 
		return DbContextHolder.getCustomerType();
	}

}
