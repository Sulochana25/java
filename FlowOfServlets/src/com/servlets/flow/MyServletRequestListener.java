package com.servlets.flow;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Application Lifecycle Listener implementation class MyServletRequestListener
 *
 */

public class MyServletRequestListener implements ServletRequestListener {

	/**
	 * Default constructor.
	 */
	public MyServletRequestListener() {
		System.out.println("servlet request Listener Constructor");
	}

	/**
	 * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
	 */
	@Override
	public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
		System.out.println("Servlet Request has been destroyed (requestDestroyed- servlet request Listener)");
		servletRequestEvent.getServletRequest();
		System.out.println("Request Destroyed :" + servletRequestEvent.getServletRequest().getServerName().toString());
		// servletRequestEvent.getServletContext().getServletContextName()
	}

	/**
	 * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
	 */
	@Override
	public void requestInitialized(ServletRequestEvent servletRequestEvent) {
		System.out.println("Servlet Request has been created (requestInitialized- servlet request Listener)");
		servletRequestEvent.getServletRequest();
		System.out
				.println("Request initialized :" + servletRequestEvent.getServletRequest().getServerName().toString());

	}

}
