package com.smforj.ssm.encrypt;

/***
 * 解密接口
 * 
 * @author Haijun Gao 
 * @date 2016-9-8 上午11:42:09
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public interface Decrypt {

	/***
	 * 解密字符串
	 * @param str 要解密的字符串
	 * @return 解密后的字符串
	 * @date 2016-9-8 上午11:40:16
	 */
	public String decrypt(String str);
}
