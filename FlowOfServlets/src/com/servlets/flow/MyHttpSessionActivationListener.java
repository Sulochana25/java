package com.servlets.flow;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * Application Lifecycle Listener implementation class
 * MyHttpSessionActivationListener
 *
 */
@WebListener
public class MyHttpSessionActivationListener implements HttpSessionActivationListener {

	/**
	 * Default constructor.
	 */
	public MyHttpSessionActivationListener() {
		System.out.println("Http session Activation Listener Constructor");
	}

	/**
	 * @see HttpSessionActivationListener#sessionDidActivate(HttpSessionEvent)
	 */
	@Override
	public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
		System.out.println("Session activated!!!!!!!!!!!");
	}

	/**
	 * @see HttpSessionActivationListener#sessionWillPassivate(HttpSessionEvent)
	 */
	@Override
	public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
		System.out.println("session passivated!!!!!!!!!!!!");
	}

}
