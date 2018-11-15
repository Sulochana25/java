package com.servlets.flow;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CallingAllListeners
 */
public class CallingAllListeners extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CallingAllListeners() {
		super();
		System.out.println("Calling All Listeners constructor");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println();

		System.out.println("Calling Servlet Context Attribute Listener");

		ServletContext servletContext = getServletContext();
		servletContext.setAttribute("Name", "Value");

		servletContext.setAttribute("Name", "NewValue");

		servletContext.removeAttribute("Name");
		System.out.println();

		System.out.println("Calling Http Session Listener");

		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		System.out.println();

		System.out.println("Calling Http Session Attribute Listener");
		httpSession = request.getSession();
		httpSession.setAttribute("SessionAttribute", "SessionAttribute Value");
		httpSession.setAttribute("SessionAttribute", "SessionAttribute New Value");
		httpSession.removeAttribute("SessionAttribute");

		System.out.println();
		System.out.println("Calling Servlet Request Attribute Listener");
		request.setAttribute("requestAttribute", "request Attribute value");
		request.setAttribute("requestAttribute", "request Attribute Newvalue");
		request.removeAttribute("requestAttirbute");
		System.out.println();

		System.out.println("Calling Http Session Binding listeners");
		MyHttpSessionBindingListener myHttpSessionBindingListener = new MyHttpSessionBindingListener("Objectname",
				"ObjectValue");

		httpSession.setAttribute("Object1", myHttpSessionBindingListener);
		httpSession.removeAttribute("Object1");
		System.out.println();

		System.out.println("leaving CallingAllListeners class");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
