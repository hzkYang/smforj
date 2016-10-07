package com.smforj.ssm.util;

/***
 * 路径校验工具类
 * 
 * @author Haijun Gao 
 * @date 2016-8-12 上午8:51:58
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public final class ViewPathUtil {

	/***
	 * 返回合法的路径
	 * @param url
	 * @return
	 * @date 2016-8-12 上午8:56:31
	 */
	public static String getValid(String url)
	{
		return url.replace("//", "/");
	}
}
