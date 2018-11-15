package com.servlets.flow;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class
 * MyHttpSessionAttributeListener
 *
 */

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

	/**
	 * Default constructor.
	 */
	public MyHttpSessionAttributeListener() {
		System.out.println("Http Session Attribute Listener Constructor");
	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("Http Session Attribute had been added (attributeAdded- Http Session Attribute Listener)");
		System.out.println(
				"Attribute Added: " + httpSessionBindingEvent.getName() + " => " + httpSessionBindingEvent.getValue());
	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out
				.println("Http Session Attribute had been removed (attributeRemoved- Http Session Attribute Listener)");
		System.out.println("Attribute Removed: " + httpSessionBindingEvent.getName() + " => "
				+ httpSessionBindingEvent.getValue());
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println(
				"Http Session Attribute had been replaced (attributeReplaced- Http Session Attribute Listener)");
		System.out.println("Attribute Replaced: " + httpSessionBindingEvent.getName() + " => "
				+ httpSessionBindingEvent.getValue());
	}

}
