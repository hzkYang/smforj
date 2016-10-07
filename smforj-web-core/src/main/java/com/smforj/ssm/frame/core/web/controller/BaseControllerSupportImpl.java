package com.smforj.ssm.frame.core.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.smforj.ssm.constant.BaseViewPath;
import com.smforj.ssm.frame.core.bean.SysCache;
import com.smforj.ssm.util.StringEx;
import com.smforj.ssm.util.ViewPathUtil;


/***
 * 基础控制器接口实现类
 * 本类只提供 ViewPath的获取实现
 * 
 * @author Haijun Gao 
 * @date 2016-7-22 下午4:54:10
 * @param <T>
 * @param <Q>
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */ 
@BaseViewPath("")
public abstract class BaseControllerSupportImpl implements BaseControllerSupport ,IHttpRequest{
	
	private Logger log = LoggerFactory.getLogger(this.getClass()); 
	
	protected HttpServletRequest request; 
    protected HttpServletResponse response; 
    protected HttpSession session; 
     
    @ModelAttribute 
    @Override
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){ 
        this.request = request; 
        this.response = response; 
        this.session = request.getSession(); 
    } 
    
	/***
	 * 获取模板名称
	 * @return
	 * @date 2016-9-7 上午11:12:26
	 */
	private String getTempletName()
	{
		String name = SysCache.getTemplete().getTemplete();
		log.debug("getTempletName:"+name);
		return StringEx.isExEmpty(name) ? "" : (name + "/");
	}

	@Override
	public String getViewPath() { 
		BaseViewPath vp = this.getClass().getAnnotation(BaseViewPath.class);
		if(vp != null)
			return ViewPathUtil.getValid(getTempletName()+vp.value());
		return "";
	}

	@Override
	public String getRedirectPath() { 
		return ViewPathUtil.getValid("redirect:/" + getViewPath());
	}

	@Override
	public String getViewPath(String view) { 
		return ViewPathUtil.getValid(getViewPath() +view);
	}

	@Override
	public String getRedirectPath(String view) {
		return ViewPathUtil.getValid("redirect:/" + view);
	}     
	
}
