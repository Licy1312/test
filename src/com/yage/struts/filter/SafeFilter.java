package com.yage.struts.filter;
/*
 * 该过滤器主要是拦截非法用户名的使用和注册
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SafeFilter extends HttpServlet implements Filter {

	private String keywords[];
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String name=request.getParameter("username");
		System.out.print(name);
		if(name!=null){
			//判断用户注册的用户名是否非法
			for(String key:keywords){
				if(key.equals(name)){
					request.setAttribute("warn", "你使用的"+name+"是非法的！");
					request.getRequestDispatcher("/WEB-INF/admin/Warn.jsp").forward(request, response);
					return;
				}
			}
			
		}
		//如果没有非法用户名，则继续向下走
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		keywords=filterConfig.getInitParameter("keywords").split(";");
	}

}
