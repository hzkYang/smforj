package com.smforj.ssm.sys.web.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.smforj.ssm.frame.core.exception.ControllerException;
import com.smforj.ssm.frame.core.web.controller.BaseControllerSupportImpl;

/***
 * 该controller 主要处理是跳转到全局界面
 * 
 * @author Haijun Gao 
 * @date 2016-9-8 下午3:07:23
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
@Controller 
public class GlobalController extends BaseControllerSupportImpl{ 
	private Logger log = Logger.getLogger(this.getClass()); 
	
	//@Autowired CookieLocaleResolver cookieResolver;
    
    @Autowired SessionLocaleResolver sessionResolver; 

    /***
     * 语言切换
     * */
    @RequestMapping("changelangsession")
    public ModelAndView sessionLanguage(String language){
         
        language=language.toLowerCase();
        if(language==null||language.equals("")){
            return new ModelAndView("redirect:/");
        }else{
            if(language.equalsIgnoreCase("zh_cn")){
            	sessionResolver.setLocale(request, response, Locale.CHINA );
            }else if(language.equalsIgnoreCase("en_us")){
            	sessionResolver.setLocale(request, response, Locale.US);
            }else{
            	sessionResolver.setLocale(request, response, Locale.CHINA );
            }
        } 
        return new ModelAndView("redirect:/");
    }
    
    /**
     * 语言切换
     */
/*    @RequestMapping(value={"changelangcookie"},method = RequestMethod.GET)
    public ModelAndView cookieLanguage(String language){ 
        language=language.toLowerCase();
        if(language==null||language.equals("")){
            return new ModelAndView("redirect:/");
        }else{
            if(language.equalsIgnoreCase("zh_cn")){
            	cookieResolver.setLocale(request, response, Locale.CHINA);
            }else if(language.equalsIgnoreCase("en_us")){
            	cookieResolver.setLocale(request, response, Locale.US);
            }else{
            	cookieResolver.setLocale(request, response, Locale.CHINA);
            }
        } 
        return new ModelAndView("redirect:/");
    }*/
	/***
	 * 跳转到message界面
	 * @param request
	 * @param message
	 * @return
	 * @date 2016-9-8 下午3:05:42
	 */
	@RequestMapping(value={"exception"},method = RequestMethod.GET)
	public ModelAndView viewException()
	{  
		log.debug("viewException");
		throw new ControllerException("viewException");
	}
	/***
	 * 跳转到message界面
	 * @param request
	 * @param message
	 * @return
	 * @date 2016-9-8 下午3:05:42
	 */
	@RequestMapping(value={"message"},method = RequestMethod.GET)
	public ModelAndView viewMessage(HttpServletRequest request,@RequestParam(required=false) String message)
	{ 
		Map<String, String> model = new HashMap<String, String>();
		model.put("message", message);
		return new ModelAndView("message",model);
	}
	
	
	/***
	 * 跳转到message界面
	 * @param request
	 * @param message
	 * @return
	 * @date 2016-9-8 下午3:05:42
	 */
	@RequestMapping(value={"error"},method = RequestMethod.GET)
	public ModelAndView viewError(HttpServletRequest request,@RequestParam(required=false) String error)
	{ 
		Map<String, String> model = new HashMap<String, String>();
		model.put("error", error);
		return new ModelAndView("error",model);
	} 
}
