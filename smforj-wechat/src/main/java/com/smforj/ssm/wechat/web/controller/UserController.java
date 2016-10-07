package com.smforj.ssm.wechat.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smforj.ssm.wechat.interceptor.OAuthRequired;

@Controller
public class UserController {
	/**
	 * 加载个人信息，此处添加了@OAuthRequired注解
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/userInfo.do"})
	@OAuthRequired
	public String load(HttpServletRequest request,Model model){
		System.out.println("Load a User!");
		HttpSession session = request.getSession();
		model.addAttribute("Userid", session.getAttribute("Userid"));
		return "user";
	}
}
