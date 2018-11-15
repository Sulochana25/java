package com.sessionmanagement.cookie;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUp
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			System.out.println("Header Name - " + headerName + ", Value - " + request.getHeader(headerName));
		}

		System.out.println("");

		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			Cookie newCookie = new Cookie(username, password);
			response.addCookie(newCookie);
			request.setAttribute(username, password);
		} else {
			request.setAttribute(cookies[0].getName(), cookies[0].getValue());
		}

		Cookie originalCookie = new Cookie(username, password);
		originalCookie.setValue("notsecure");
		// originalCookie.setValue(password);
		response.addCookie(originalCookie);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Welcome");
		requestDispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}