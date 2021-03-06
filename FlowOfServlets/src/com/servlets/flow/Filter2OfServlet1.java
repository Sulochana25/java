package com.servlets.flow;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class Filter2OfServlet1
 */

public class Filter2OfServlet1 implements Filter {

	public Filter2OfServlet1() {
		System.out.println("Filter 2 of Servlet 1 constructor called!!");
	}

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("Filter 2 of Servlet 1 destroyed ....");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Entered into Filter 2 of Servlet 1");

		response.getWriter().append("Entered into Filter 2 of Servlet 1\n");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter 2 of Servlet 1 initialized");
	}

}
