package com.smforj.ssm.encrypt;

/***
 * 加密接口
 * 
 * @author Haijun Gao 
 * @date 2016-9-8 上午11:39:24
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public interface Encrypt {
	
	/***
	 * 加密字符串
	 * @param str 要加密的字符串
	 * @return 加密后的字符串
	 * @date 2016-9-8 上午11:40:16
	 */
	public String encode(String str);

}
