package com.smforj.ssm.sys.web.controller.admin;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smforj.ssm.constant.BaseViewPath;
import com.smforj.ssm.frame.core.web.controller.BaseControllerSupportImpl;
import com.smforj.ssm.sys.web.bean.SysUser;

@BaseViewPath("")
@Controller
@RequestMapping(value={"/admin"})
public class _IndexController extends BaseControllerSupportImpl{ 
	
    private static String LOGIN = "login"; 
    private static String INDEX = "index";
	private Logger log = Logger.getLogger(this.getClass());  
	
	@RequestMapping(value="index",method=RequestMethod.GET) 
	public ModelAndView index(ModelMap model)
	{
		log.debug("index=========================begin");
		ModelAndView mav = new ModelAndView();
		Object manager = this.session.getAttribute("manager");
		if(manager == null)
		{
			model.addAttribute("flag", true);
			model.addAttribute("message", "请先登陆系统!!!");
			mav.setViewName(this.getViewPath(LOGIN));
			return mav;
		}  
		model.addAttribute("username", ((SysUser)manager).getUsername());
		mav.setViewName(this.getViewPath(INDEX));
		log.debug("index=========================end");
		return mav;
	}
}
