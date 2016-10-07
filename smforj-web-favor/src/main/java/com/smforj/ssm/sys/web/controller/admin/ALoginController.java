package com.smforj.ssm.sys.web.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smforj.ssm.frame.core.web.controller.BaseControllerSupportImpl;
 
public class ALoginController extends BaseControllerSupportImpl{ 
	
    private static String LOGIN = "login";
	private Logger log = Logger.getLogger(this.getClass());  
	
	
	/***
	 * 注册
	 * @return
	 * @date 2016-8-11 下午2:12:06
	 */
	@RequestMapping(value={"login"},method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) 
	public ModelAndView gologin(HttpServletRequest request,ModelMap model)
	{ 
		log.debug("gologin=============================begin");  
		
		log.debug("gologin=============================end");  
		return new ModelAndView(this.getViewPath(LOGIN));
	}
	
	/***
	 * 注册
	 * @return
	 * @date 2016-8-11 下午2:12:06
	 */
	@RequestMapping(value={"login"},method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE) 
	public ModelAndView dologin(HttpServletRequest request,ModelMap model)
	{ 
		log.debug("dologin=============================begin");  
		
		log.debug("dologin=============================end");  
		return new ModelAndView(this.getViewPath(LOGIN));
	}
}
