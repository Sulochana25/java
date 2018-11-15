package com.servlets.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *
 */
public class LoginListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public LoginListener() {

	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent contextDestroyed) {
		String user = (String) contextDestroyed.getServletContext().getAttribute("user");

		System.out.println("User Looged out successfully");
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent contextInitialized) {
		ServletContext context = contextInitialized.getServletContext();
		context.setAttribute("Tip of the day", "No tips");

	}

}
