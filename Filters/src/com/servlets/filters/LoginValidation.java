package com.servlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class LoginValidation
 */
@WebFilter(filterName = "Login", urlPatterns = { "/Login" })
public class LoginValidation implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginValidation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String username = request.getParameter("username");
		int length = username.length();
		String company = username.substring(length - 3);
		System.out.println(company);

		if (company.equalsIgnoreCase("ggk")) {
			chain.doFilter(request, response);
		} else {
			response.getWriter().append("Unauthorised User");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
