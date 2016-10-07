package com.smforj.ssm.frame.core.plugin;

/***
 * 
 * 
 * @author Haijun Gao 
 * @date 2016-9-6 上午9:47:48
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public interface IPlugin {
	/***
	 * 启动
	 * @return
	 * @date 2016-9-6 上午9:48:00
	 */
	boolean start();
	/***
	 * 停止
	 * @return
	 * @date 2016-9-6 上午9:48:00
	 */
	boolean stop();
	
	/***
	 * 是否正在运行
	 * @return
	 * @date 2016-9-6 上午10:20:48
	 */
	boolean isStart();
}
