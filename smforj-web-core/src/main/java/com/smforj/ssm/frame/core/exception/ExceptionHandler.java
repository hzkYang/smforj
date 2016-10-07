package com.smforj.ssm.frame.core.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView; 

import com.smforj.ssm.frame.core.bean.SysCache;
import com.smforj.ssm.util.StringEx;

/***
 * 全局异常处理对象
 * 
 * @author Haijun Gao 
 * @date 2016-9-10 上午11:28:15
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) { 
		
	   log.debug("resolveException: "+ex); 
       Map<String, Object> model = new HashMap<String, Object>();  
       model.put("ex", ex);  
         
       // 根据不同错误转向不同页面  
       if(ex instanceof ControllerException) {  
           return getModelAndView("error-controller", model);  
       }else if(ex instanceof ServiceException) {  
           return getModelAndView("error-service", model);  
       } else {  
           return getModelAndView("error", model);  
       }   
	}
	/***
	 * 创建modelandview 对象
	 * @param viewName
	 * @param model
	 * @return
	 * @date 2016-9-10 下午12:10:21
	 */
	private ModelAndView getModelAndView(String viewName, Map<String, ?> model)
	{
		return new ModelAndView(getView(viewName),model);
	}
	
	/***
	 * 获取 view 路径包含templete
	 * @param viewName
	 * @return
	 * @date 2016-9-10 下午12:09:23
	 */
	private String getView(String viewName)
	{
		String name = SysCache.getTemplete().getTemplete(); 
		return StringEx.isExEmpty(name) ? viewName : (name + "/"+viewName); 
	} 
	
 

}
