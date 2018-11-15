package com.servlets.flow;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * Application Lifecycle Listener implementation class
 * MyServletRequestAttributeListener
 *
 */

public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {

	/**
	 * Default constructor.
	 */
	public MyServletRequestAttributeListener() {
		System.out.println("Servlet Request Attribute Listener constructor ");
	}

	/**
	 * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
	 */
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
		System.out.println(
				"Servlet Request Attribute had been removed (attributeRemoved- Servlet Request Attribute Listener)");
		System.out.println("Attribute Added: " + servletRequestAttributeEvent.getName() + " => "
				+ servletRequestAttributeEvent.getValue());
	}

	/**
	 * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
	 */
	@Override
	public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
		System.out.println(
				"Servlet Request Attribute had been added (attributeAdded- Servlet Request Attribute Listener)");
		System.out.println("Attribute Added: " + servletRequestAttributeEvent.getName() + " => "
				+ servletRequestAttributeEvent.getValue());
	}

	/**
	 * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
	 */
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
		System.out.println(
				"Servlet Request Attribute had been replaced (attributeReplaced- Servlet Request Attribute Listener)");
		System.out.println("Attribute Replaced: " + servletRequestAttributeEvent.getName() + " => "
				+ servletRequestAttributeEvent.getValue());
	}

}
