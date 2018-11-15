package com.social.instagram.logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	public SignUp() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = getServletContext();
		con = (Connection) context.getAttribute("connection");

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String emailID = request.getParameter("emailid");
		String password = request.getParameter("userpwd");
		String cnfrmPassword = request.getParameter("cnfrmpwd");

		SignUpBean signupBean = new SignUpBean();
		signupBean.setEmailId(emailID);
		signupBean.setFirstName(firstName);
		signupBean.setLastName(lastName);
		context.setAttribute("signupBean", signupBean);

		ResultSet rs;
		int userid = 0;
		if (password == "" || cnfrmPassword == "" || password == null || cnfrmPassword == null) {
			PrintWriter out = response.getWriter();
			out.println(
					"<html><body><script>alert('Password cannot be null.Enter a Valid Password');window.location.href='SignUp.jsp'; </script></body></html>");

		} else if (!(password.equals(cnfrmPassword))) {
			PrintWriter out = response.getWriter();
			out.println(
					"<html><body><script>alert('Passwords Do not Match!');window.location.href='SignUp.jsp'; </script></body></html>");
		} else {
			try {
				PreparedStatement preparedStatement = con.prepareStatement("insert into SnapGGKUsers values(?,?,?,?)",
						Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, firstName);
				preparedStatement.setString(2, lastName);
				preparedStatement.setString(3, emailID);
				preparedStatement.setString(4, password);
				preparedStatement.executeUpdate();

				rs = preparedStatement.getGeneratedKeys();
				if (rs != null && rs.next()) {
					userid = rs.getInt(1);
				}

				preparedStatement = con.prepareStatement(
						"insert into userDetails(userid,emailid,password,displayPicture,firstname,lastname) values(?,?,?,?,?,?)");
				preparedStatement.setInt(1, userid);
				preparedStatement.setString(2, emailID);
				preparedStatement.setString(3, password);
				preparedStatement.setString(4, "./images/3.jpg");
				preparedStatement.setString(5, firstName);
				preparedStatement.setString(6, lastName);
				preparedStatement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			request.getRequestDispatcher("LogIn.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
