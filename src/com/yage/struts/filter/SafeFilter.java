package com.yage.struts.filter;
/*
 * �ù�������Ҫ�����طǷ��û�����ʹ�ú�ע��
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
			//�ж��û�ע����û����Ƿ�Ƿ�
			for(String key:keywords){
				if(key.equals(name)){
					request.setAttribute("warn", "��ʹ�õ�"+name+"�ǷǷ��ģ�");
					request.getRequestDispatcher("/WEB-INF/admin/Warn.jsp").forward(request, response);
					return;
				}
			}
			
		}
		//���û�зǷ��û����������������
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		keywords=filterConfig.getInitParameter("keywords").split(";");
	}

}
