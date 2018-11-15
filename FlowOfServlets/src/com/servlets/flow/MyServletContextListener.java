package com.servlets.flow;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *
 */
public class MyServletContextListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public MyServletContextListener() {
		System.out.println("Constructor of Servlet Context Listener");
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("Servlet Context has been destroyed (contextDestroyed- Servlet context Listener)\n\n");

	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("Servlet context has been initialized (contextInitialized- Servlet Context Listener)");
	}

}
