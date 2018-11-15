package com.servlets.flow;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Application Lifecycle Listener implementation class
 * MyHttpSessionBindingListener
 *
 */
public class MyHttpSessionBindingListener implements HttpSessionBindingListener {

	String attributeName;
	String attributeValue;

	/**
	 * Default constructor.
	 */
	public MyHttpSessionBindingListener() {
		System.out.println("Http Session Binding Listener constructor");
	}

	public MyHttpSessionBindingListener(String attributeName, String attributeValue) {
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
	}

	/**
	 * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("Object " + httpSessionBindingEvent.getName() + " is bound");
	}

	/**
	 * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("Object " + httpSessionBindingEvent.getName() + " is unbound");
	}

}
