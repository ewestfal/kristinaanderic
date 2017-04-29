package com.kristinaanderic.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kristinaanderic.core.Kernel;
import com.kristinaanderic.persistence.Persistable;

/**
 * @author Eric Westfall
 * @created Aug 24, 2004
 */
public class WebUtils {
	
	public static Persistable getPersistable(Class persistableClass, String attributeName, HttpSession session)
	{
		if (session == null) throw new IllegalArgumentException("Session cannot be null.");
		if (attributeName == null) throw new IllegalArgumentException("Attribute name cannot be null.");
		return getPersistable(persistableClass, session.getAttribute(attributeName));
	}
	
	public static Persistable getPersistable(Class persistableClass, String attributeName, HttpServletRequest request) {
		if (request == null) throw new IllegalArgumentException("Request cannot be null.");
		if (attributeName == null) throw new IllegalArgumentException("Attribute name cannot be null.");
		return getPersistable(persistableClass, request.getAttribute(attributeName));
	}
	
	private static Persistable getPersistable(Class persistableClass, Object identifier) {
		if (persistableClass == null) throw new IllegalArgumentException("Persistable class cannot be null.");
		if (identifier == null || !(identifier instanceof Long)) return null;
		System.out.println("Getting persistable: " + persistableClass+","+identifier);
		System.out.println("Loading! " + (Long)identifier+","+persistableClass);
		return Kernel.getCore().getPersistenceEngine().load((Long)identifier, persistableClass);
	}
	
	
}
