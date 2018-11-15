package com.social.instagram.logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	public LogIn() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = getServletContext();
		con = (Connection) context.getAttribute("connection");

		ResultSet rs;
		PreparedStatement preparedStatement;
		String emailid = request.getParameter("emailid");
		String password = request.getParameter("userpwd");

		LoginBean loginBean = new LoginBean();
		loginBean.setEmailid(emailid);
		context.setAttribute("loginBean", loginBean);

		try {
			preparedStatement = con.prepareStatement("select * from SnapGGKUsers where emailid=? and password=?");

			preparedStatement.setString(1, emailid);
			preparedStatement.setString(2, password);

			rs = preparedStatement.executeQuery();

			if (rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("userid", rs.getInt(1));
				response.sendRedirect("/Instagram/UserProfile.jsp");
			} else {
				PrintWriter out = response.getWriter();
				out.println(
						"<html><body><script>alert('Incorrect emailid or password');window.location.href='index.jsp'; </script></body></html>");
			}
		} catch (SQLException e) {
			PrintWriter out = response.getWriter();
			out.println(
					"<html><body><script>alert('Could not connect to the database');window.location.href='index.jsp'; </script></body></html>");
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
