package com.Servlet.SampleRun;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/Servlet", loadOnStartup = 1)
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SampleServlet() {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletConfig obj = getServletConfig();

		response.getWriter().append(obj.getInitParameter("company"));
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: Hello ").append(request.getParameter("password"));
	}

}
