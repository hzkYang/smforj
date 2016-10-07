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



public class PluginFilter extends HttpServlet implements Filter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6594619436075541922L;
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException { 
		log.debug("PluginFilter init=============================");    
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		log.debug("PluginFilter doFilter============================="); 
		
		chain.doFilter(request, response);
		
	} 

}
