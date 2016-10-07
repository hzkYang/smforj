package com.smforj.ssm.frame.core.enums;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.TYPE })  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public @interface MethodLog {  
	/***
	 * 描述
	 * @return
	 * @date 2016-9-9 下午1:54:11
	 */
	String remark() default "";  
	/***
	 * 操作类型 添加、删除 、修改等 
	 * @return
	 * @date 2016-9-9 下午1:54:21
	 */
    String operType() default "0";  
} 
