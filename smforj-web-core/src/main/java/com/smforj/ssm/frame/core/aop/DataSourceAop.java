package com.smforj.ssm.frame.core.aop;
 
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.smforj.ssm.frame.core.dao.DbContextHolder;

/**
 * 数据库源拦截器
 * 
 * 
 * @author Haijun Gao 
 * @date 2016-8-5 下午5:45:01
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */ 
public class DataSourceAop {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	 
	public void setDataSource(JoinPoint jp) {
		log.info("setDataSource...");
		System.out.println("setDataSource...");     
	      //获取目标对象对应的类名     
        String className = jp.getTarget().getClass().getName();     
        //获取目标对象上正在执行的方法名     
        String methodName = jp.getSignature().getName();     
             
        System.out.println("前置通知:" + className + "类的" + methodName + "方法开始了"+jp.getArgs());     
    
		DbContextHolder.setCustomerType("mdefault");
	} 

}
