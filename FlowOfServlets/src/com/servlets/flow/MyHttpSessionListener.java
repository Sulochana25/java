package com.servlets.flow;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyHttpSessionListener
 *
 */

public class MyHttpSessionListener implements HttpSessionListener {

	/**
	 * Default constructor.
	 */
	public MyHttpSessionListener() {
		System.out.println("Http Session Listener Constructor");
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		System.out.println("Http Session is created (sessionCreated - Http Session Listener)");
		System.out.println("Session with ID: " + httpSessionEvent.getSession().getId() + " has been created");

	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		System.out.println("Http Session is destroyed (sessionDestroyed - Http Session Listener)");
		System.out.println("Session with ID: " + httpSessionEvent.getSession().getId() + " has been destroyed");

	}

}
