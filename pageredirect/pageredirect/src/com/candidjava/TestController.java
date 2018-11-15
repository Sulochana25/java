package com.candidjava;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestController
 */
public class TestController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String un = request.getParameter("username");
		String pw = request.getParameter("password");
		System.out.println("data received");
		System.out.println(un + "  " + pw);
		response.getWriter().append("TestControlller\n");
		// ServletContext sc = request.getServletContext();
		RequestDispatcher rd = request.getRequestDispatcher("Test");
		rd.forward(request, response);
		// response.sendRedirect("Test");
		// response.getWriter().append("\ndone\n");

	}

}
