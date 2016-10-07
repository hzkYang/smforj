package com.smforj.ssm.constant;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * dao的注解对象 使用于扫描
 * 
 * @author Haijun Gao 
 * @date 2016-8-9 下午5:00:36
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BaseViewPath { 
	/***
	 * View 路径 目录
	 * @return
	 * @date 2016-8-11 下午1:45:18
	 */
	String value() default "";
}
