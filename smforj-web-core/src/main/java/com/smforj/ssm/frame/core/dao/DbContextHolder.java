package com.smforj.ssm.frame.core.dao;

/***
 * 数据源Context Holder对象
 * 
 * @author Haijun Gao 
 * @date 2016-8-5 下午5:15:32
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public class DbContextHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	/***
	 * 设置当前数据源类型 
	 * @param customerType 不同用户不同数据源
	 * @date 2016-8-5 下午5:15:56
	 */
	public static void setCustomerType(String customerType) {
		contextHolder.set(customerType);
	}

	/***
	 * 获取当前数据源类型
	 * @return 返回数据源类型
	 * @date 2016-8-5 下午5:17:05
	 */
	public static String getCustomerType() {
		return contextHolder.get();
	}

	/***
	 * 清除上下文数据 
	 * 
	 * @date 2016-8-5 下午5:17:30
	 */
	public static void clearCustomerType() {
		contextHolder.remove();
	}
}
