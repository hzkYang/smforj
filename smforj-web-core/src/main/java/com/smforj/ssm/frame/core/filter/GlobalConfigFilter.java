package com.smforj.ssm.frame.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.smforj.ssm.frame.core.bean.SysCache;
import com.smforj.ssm.frame.core.enums.SystemInfo;
import com.smforj.ssm.frame.core.web.domain.Templete;
import com.smforj.ssm.util.PropKit;

/****
 * 系统配置Filter 
 * 系统加载时要加载的信息在该对象中进行配置
 * 
 * @author Haijun Gao 
 * @date 2016-9-9 下午2:11:31
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public class GlobalConfigFilter extends HttpServlet implements Filter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6594619436075541922L;
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException { 
		log.debug("SysConfigFilter init=============================");  
		loadsys();
	}
	
	/***
	 * 加载系统配置信息
	 * 
	 * @date 2016-9-9 下午2:19:13
	 */
	private void loadsys()
	{
		PropKit.use("sys.properties"); 
		log.debug("load sys.properties=============================");
		
		SystemInfo sys = new SystemInfo();
		sys.setDefaultAdminTemplete(PropKit.get("default_front_templete"));
		sys.setDefaultAdminTemplete(PropKit.get("default_admin_templete"));
		SysCache.setSys(sys);
		
		//默认为后台模板
		Templete templete = new Templete();
		templete.setDefault_templete(PropKit.get("default_admin_templete"));
		SysCache.setTemplete(templete);
		log.debug("load sys======================================");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		log.debug("SysConfigFilter doFilter============================="); 
		
		
		log.debug("request.getContentType doFilter============================="+request.getContentType()); 
		chain.doFilter(request, response);
		
	} 

}
