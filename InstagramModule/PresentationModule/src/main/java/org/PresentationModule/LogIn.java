package org.PresentationModule;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.CommonUtils.Constants;
import org.CommonUtils.LoginBean;
import org.ServiceModule.ServiceLogin;
import org.apache.log4j.Logger;

public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(LogIn.class);

	public LogIn() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.debug("Application login !!");

		ServletContext context = getServletContext();

		String emailId = request.getParameter(Constants.EMAILID);
		String password = request.getParameter(Constants.LOGINPASSWORD);

		LoginBean loginBean = new LoginBean();
		logger.info("setting login values to login bean");
		loginBean.setEmailid(emailId);
		loginBean.setPassword(password);
		context.setAttribute(Constants.LOGINBEAN, loginBean);

		int validUser = ServiceLogin.getInstance().getUser(loginBean);
		if (validUser != -1) {
			context.setAttribute(Constants.USERID, validUser);
			response.sendRedirect("UserHomePage");
		} else if (validUser == -2) {
			request.setAttribute("message", "Unauthorized login");
			request.getRequestDispatcher("exception.jsp").forward(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
