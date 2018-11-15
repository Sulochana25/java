package org.PresentationModule;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.CommonUtils.Constants;
import org.CommonUtils.SignUpBean;
import org.ServiceModule.ServiceSignup;

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignUp() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = getServletContext();

		String firstName = request.getParameter(Constants.FIRSTNAME);
		String lastName = request.getParameter(Constants.LASTNAME);
		String emailID = request.getParameter(Constants.EMAILID);
		String password = request.getParameter(Constants.LOGINPASSWORD);

		SignUpBean signupBean = new SignUpBean();
		signupBean.setEmailId(emailID);
		signupBean.setFirstName(firstName);
		signupBean.setLastName(lastName);
		signupBean.setPassword(password);
		context.setAttribute(Constants.SIGNUPBEAN, signupBean);

		int isRegistered = ServiceSignup.getInstance().RegisterUser(signupBean);
		if (isRegistered == -1) {
			request.setAttribute("message", "Sign Up request cannot be processed right now");
			request.getRequestDispatcher("exception.jsp").forward(request, response);

		} else if (isRegistered == 1) {
			request.getRequestDispatcher("LogIn.jsp").forward(request, response);
		} else {
			response.sendRedirect("SignUp.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
