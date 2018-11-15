package org.PresentationModule;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.CommonUtils.Constants;
import org.CommonUtils.NewPostBean;
import org.CommonUtils.SetBeanValues;
import org.CommonUtils.UserDetailsBean;
import org.ServiceModule.ServiceUserProfile;
import org.apache.log4j.Logger;

public class UserHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(UserHomePage.class);

	public UserHomePage() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ServletContext context = getServletContext();
			List<NewPostBean> posts;
			List<String> userDetails;

			logger.info("gettng user id from context");
			int userid = (Integer) context.getAttribute(Constants.USERID);
			posts = ServiceUserProfile.getInstance().getUserInformation(userid);
			context.setAttribute("posts", posts);

			userDetails = ServiceUserProfile.getInstance().getUserDetails(userid);

			UserDetailsBean userDetailsBean = new UserDetailsBean();
			logger.debug("Setting bean details");
			userDetailsBean = (UserDetailsBean) SetBeanValues.setBeanValue(userDetailsBean, userDetails.get(0),
					userDetails.get(1), userDetails.get(2), userDetails.get(4), userDetails.get(5), userDetails.get(3));

			context.setAttribute(Constants.USERDETAILSBEAN, userDetailsBean);

			request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
		} catch (NullPointerException e) {
			System.out.println("The result is null");
			logger.error("Caught with null pointer exception");
			request.setAttribute("exception", "Unauthorized request");
			request.getRequestDispatcher("exception.jsp").forward(request, response);
		} catch (ClassCastException e) {
			System.out.println("The result is null");
			logger.error("Caught an expection", e);
			request.setAttribute("exception", "Unauthorized request");
			request.getRequestDispatcher("exception.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
