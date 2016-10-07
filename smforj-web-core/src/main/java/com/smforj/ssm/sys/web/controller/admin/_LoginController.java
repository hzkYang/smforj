package com.smforj.ssm.sys.web.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.smforj.ssm.constant.BaseViewPath;
import com.smforj.ssm.frame.core.web.controller.BaseControllerSupportImpl;
import com.smforj.ssm.frame.core.web.domain.Result;
import com.smforj.ssm.frame.core.web.domain.Result.Status;
import com.smforj.ssm.sys.restful.domain.UserCache;
import com.smforj.ssm.sys.web.service.LoginService;
import com.smforj.ssm.util.StringEx;

@BaseViewPath("")
@Controller
@RequestMapping(value={"/admin"})
public class _LoginController extends BaseControllerSupportImpl{ 
	
    private static String LOGIN = "login";
    private static String INDEX = "admin/index";
	private Logger log = Logger.getLogger(this.getClass()); 
	
	@Autowired
	private LoginService loginService; 
	
	/***
	 * 注册
	 * @return
	 * @date 2016-8-11 下午2:12:06
	 */
	@RequestMapping(value={"login"},method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) 
	public ModelAndView gologin(HttpServletRequest request,ModelMap model)
	{ 
		log.debug("gologin=============================");   
		return new ModelAndView(this.getViewPath(LOGIN));
	}
	
	/***
	 * 登陆
	 * @return
	 * @date 2016-8-11 下午2:12:06
	 */
	@RequestMapping(value={"login"},method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE) 
	public ModelAndView dologin(HttpServletRequest request,ModelMap model)
	{ 
		log.debug("dologin=============================begin");  
		ModelAndView mav = new ModelAndView();  
		String username = request.getParameter("username");
		String password = request.getParameter("password"); 
		String ip = request.getRemoteAddr();
		if(StringEx.isExEmpty(username) || StringEx.isExEmpty(password))
		{
			model.addAttribute("message", "用户名或密码错误!!!");
			model.addAttribute("flag", true);
			mav.setViewName(this.getViewPath(LOGIN));
			return mav;
		}
		log.debug(String.format("username %s password %s ip %s ",username,password,ip)); 
		UserCache uc = loginService.login(username, password, ip);
		if(uc != null)
		{ 
			//加载权限信息
			//###############################################
			
			//###############################################
			model.addAttribute("flag", false);
			model.addAttribute("message", "success");
			this.session.setAttribute("manager", uc.getUser());
			mav.setViewName(this.getRedirectPath(INDEX));
		}else
		{ 
			model.addAttribute("flag", true);
			model.addAttribute("message", "用户名或密码错误!!!");
			mav.setViewName(this.getViewPath(LOGIN));
		}
		log.debug("UserCache:"+uc);  
		log.debug("dologin=============================end");  
		return mav;
	}
	
	/***
	 * 登陆
	 * @return
	 * @date 2016-8-11 下午2:12:06
	 */
	@RequestMapping(value={"loginjson"},method = RequestMethod.POST, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Result dologinjson(HttpServletRequest request,ModelMap model)
	{ 
		log.debug("dologinjson=============================begin");  
		Result result = new Result();  
		String username = request.getParameter("username");
		String password = request.getParameter("password"); 
		String ip = request.getRemoteAddr();
		if(StringEx.isExEmpty(username) || StringEx.isExEmpty(password))
		{
			result.setStatus(Status.ERROR);
			result.setMessage("用户名或密码为空!!!");
			return result;
		}
		
		log.debug(String.format("username %s password %s ip %s ",username,password,ip)); 
		UserCache uc = loginService.login(username, password, ip);
		if(uc != null)
		{ 
			//加载权限信息
			model.addAttribute("message", "success");
			model.addAttribute("manager", uc.getUser());
			result.setStatus(Status.OK);
		}else
		{
			model.addAttribute("message", "用户名或密码错误!!!");
			result.setStatus(Status.ERROR);
			result.setMessage("用户名或密码错误!!!");
		}
		log.debug("UserCache:"+uc);  
		log.debug("dologinjson=============================end");  
		return result;
	}
	
	/***
	 * sign up
	 * @return
	 * @date 2016-8-11 下午2:12:06
	 */
	@RequestMapping(value={"logout"},method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE) 
	public ModelAndView logout(HttpServletRequest request)
	{ 
		log.debug("logout=============================begin");  
		ModelAndView mav = new ModelAndView();  
		String sessionid = this.request.getParameter("sessionid");   
		loginService.logout(sessionid); 
		mav.setViewName(this.getViewPath(LOGIN));
		log.debug("logout=============================end");  
		return mav;
	}
}
