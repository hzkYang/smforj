package com.smforj.ssm.sys.web.service;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.smforj.ssm.frame.core.enums.MethodLog;
import com.smforj.ssm.sys.web.dao.OperlogDao;

public class OperlogService {
 
	@Autowired
    private OperlogDao operlogDao;  
  
    public OperlogService() {  
        System.out.println("Aop");  
    }  
  
    /** 
     * 在Spring 
     * 2.0中，Pointcut的定义包括两个部分：Pointcut表示式(expression)和Pointcut签名(signature 
     * )。让我们先看看execution表示式的格式： 
     * 括号中各个pattern分别表示修饰符匹配（modifier-pattern?）、返回值匹配（ret 
     * -type-pattern）、类路径匹配（declaring 
     * -type-pattern?）、方法名匹配（name-pattern）、参数匹配（(param 
     * -pattern)）、异常类型匹配（throws-pattern?），其中后面跟着“?”的是可选项。 
     *  
     * @param point 
     * @throws Throwable 
     */  
  
    @Pointcut("@annotation(com.smforj.ssm.frame.core.bean.MethodLog)")  
    public void methodCachePointcut() {  
  
    }  
  
    // // @Before("execution(* com.wssys.controller.*(..))")  
    // public void logAll(JoinPoint point) throws Throwable {  
    // System.out.println("打印========================");  
    // }  
    //  
    // // @After("execution(* com.wssys.controller.*(..))")  
    // public void after() {  
    // System.out.println("after");  
    // }  
  
    // 方法执行的前后调用  
    // @Around("execution(* com.wssys.controller.*(..))||execution(* com.bpm.*.web.account.*.*(..))")  
    // @Around("execution(* com.wssys.controller.*(..))")  
    // @Around("execution(* org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter.handle(..))")  
    @Around("methodCachePointcut()")  
    public Object around(ProceedingJoinPoint point) throws Throwable {  
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder  
                .getRequestAttributes()).getRequest();  
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");  
        Calendar ca = Calendar.getInstance();  
        String operDate = df.format(ca.getTime());  
        //String ip = TCPIPUtil.getIpAddr(request);  
        //PusSysUser user = (PusSysUser) SecurityUtils.getSubject()  
                //.getPrincipal();  
/*        String loginName;  
        String name;  
        if (user != null) {  
            loginName = user.getAccount();  
            // name = user.name;  
        } else {  
            loginName = "匿名用户";  
            // name = "匿名用户";  
        }  */
  
        String monthRemark = getMthodRemark(point);  
        String monthName = point.getSignature().getName();  
        String packages = point.getThis().getClass().getName();  
        if (packages.indexOf("$$EnhancerByCGLIB$$") > -1) { // 如果是CGLIB动态生成的类  
            try {  
                packages = packages.substring(0, packages.indexOf("$$"));  
            } catch (Exception ex) {  
                ex.printStackTrace();  
            }  
        }  
  
        String operatingcontent = "";  
        Object[] method_param = null;  
  
        Object object;  
        try {  
            method_param = point.getArgs(); //获取方法参数   
            // String param=(String) point.proceed(point.getArgs());  
            object = point.proceed();  
        } catch (Exception e) {  
            // 异常处理记录日志..log.error(e);  
            throw e;  
        }  
        
        //写日志  
        return object;  
    }  
  
    // 方法运行出现异常时调用    
    // @AfterThrowing(pointcut = "execution(* com.wssys.controller.*(..))",  
    // throwing = "ex")  
    public void afterThrowing(Exception ex) {  
        System.out.println("afterThrowing");  
        System.out.println(ex);  
    }  
  
    // 获取方法的中文备注____用于记录用户的操作日志描述  
    @SuppressWarnings("rawtypes")
	public static String getMthodRemark(ProceedingJoinPoint joinPoint)  
            throws Exception {  
        String targetName = joinPoint.getTarget().getClass().getName();  
        String methodName = joinPoint.getSignature().getName();  
        Object[] arguments = joinPoint.getArgs();  
  
        Class targetClass = Class.forName(targetName);  
        Method[] method = targetClass.getMethods();  
        String methode = "";  
        for (Method m : method) {  
            if (m.getName().equals(methodName)) {  
                Class[] tmpCs = m.getParameterTypes();  
                if (tmpCs.length == arguments.length) {  
                    MethodLog methodCache = m.getAnnotation(MethodLog.class);  
                    if (methodCache != null) {  
                        methode = methodCache.remark();  
                    }  
                    break;  
                }  
            }  
        }  
        return methode;  
    }  
}
