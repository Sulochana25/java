package com.servlets.listeners;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */

public class SessionListener implements HttpSessionListener {

	/**
	 * Default constructor.
	 */
	public SessionListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		HttpSession session = sessionEvent.getSession();
		session.setMaxInactiveInterval(60);

	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("User logged out successfully");
	}

}
