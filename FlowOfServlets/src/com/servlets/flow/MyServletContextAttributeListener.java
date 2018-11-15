package com.servlets.flow;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Application Lifecycle Listener implementation class
 * MyServletContextAttributeListener
 *
 */

public class MyServletContextAttributeListener implements ServletContextAttributeListener {

	/**
	 * Default constructor.
	 */
	public MyServletContextAttributeListener() {
		System.out.println("Servlet Context Attribute Listener Constructor called..");
	}

	/**
	 * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
	 */
	@Override
	public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
		System.out.println(
				"Servlet Context Attribute had been added (attributeAdded- Servlet Context Attribute Listener)");
		System.out.println("Attribute Added: " + servletContextAttributeEvent.getName() + " => "
				+ servletContextAttributeEvent.getValue());

	}

	/**
	 * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
	 */
	@Override
	public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
		System.out.println(
				"Servlet Context Attribute had been removed (attributeRemoved- Servlet Context Attribute Listener)");
		System.out.println("Attribute Removed: " + servletContextAttributeEvent.getName() + " => "
				+ servletContextAttributeEvent.getValue());
	}

	/**
	 * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
	 */
	@Override
	public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
		System.out.println(
				"Servlet Context Attribute had been replaced (attributeReplaced- Servlet Context Attribute Listener)");
		System.out.println("Attribute replaced: " + servletContextAttributeEvent.getName() + " => "
				+ servletContextAttributeEvent.getValue());
	}

}
