package com.smforj.ssm.frame.core.aop;
 
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.smforj.ssm.frame.core.bean.SysCache;

/**
 * 数据库源拦截器
 * 
 * 
 * @author Haijun Gao 
 * @date 2016-8-5 下午5:45:01
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */ 
public class TempleteAop {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	 
	public void setTempleteAdmin(JoinPoint jp) { 
		log.debug("setTempleteAdmin==========================begin");  
		
	     //获取目标对象对应的类名     
        String className = jp.getTarget().getClass().getName();   
        if(className.contains("admin"))
        { 
        	SysCache.getTemplete().setTemplete(SysCache.getSys().getDefaultAdminTemplete());
        	System.out.println("设置模板："+SysCache.getSys().getDefaultAdminTemplete()); 
        }
        
        //获取目标对象上正在执行的方法名     
        String methodName = jp.getSignature().getName();   
        System.out.println("前置通知:" + className + "类的" + methodName + "方法开始了");   
		log.debug("setTempleteAdmin==========================end");
	} 

	
	public void setTempleteFront(JoinPoint jp) { 
		log.debug("setTempleteFront==========================begin");  
		
	     //获取目标对象对应的类名     
        String className = jp.getTarget().getClass().getName();   
        if(className.contains("front"))
        {
        	SysCache.getTemplete().setTemplete(SysCache.getSys().getDefaultFrontTemplete());
        	System.out.println("设置模板："+SysCache.getSys().getDefaultFrontTemplete());
        }
        
        //获取目标对象上正在执行的方法名     
        String methodName = jp.getSignature().getName();     
             
        System.out.println("前置通知:" + className + "类的" + methodName + "方法开始了");  
		
		log.debug("setTempleteFront==========================end");
	} 
}
