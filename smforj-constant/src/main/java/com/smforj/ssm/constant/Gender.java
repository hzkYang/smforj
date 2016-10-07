package com.smforj.ssm.constant;

/***
 * 性别
 * 
 * @author Haijun Gao 
 * @date 2016-7-31 下午4:26:37
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public enum Gender implements BaseEnum{
	MEN("男"), WEMEN("女");
	
	private String name;
	
	private Gender(String gender)
	{
		this.name = gender;
	}

	@Override
	public String getName() { 
		return name;
	} 
}
