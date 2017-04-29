/*
 * Created on Aug 14, 2004
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.kristinaanderic.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kristinaanderic.persistence.PersistenceEngine;

/**
 * @author ewestfal
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class Core {
	
	private static final String[] CONTEXT_RESOURCES =
        { "*Context.xml" };
	//private static final String[] CONTEXT_RESOURCES =
	//	new String[] { "kernel/test/conf/dataSourceContext.xml", "kernel/conf/daoContext.xml", "kernel/conf/persistenceContext.xml", "kernel/conf/transactionContext.xml" };
	private static final String PERSISTENCE_ENGINE = "persistenceEngine";
	
	private ClassPathXmlApplicationContext context;
	//private  FileSystemXmlApplicationContext context;
	
	public Core() {
		//ClassLoader cl = ClassLoader.getSystemClassLoader();
		//System.out.println("dsc 1: " + cl.getResource("dataSourceContext.xml"));
		//cl = getClass().getClassLoader();
		//System.out.println("dsc 2: " + cl.getResource("dataSourceContext.xml"));
		context = new ClassPathXmlApplicationContext(CONTEXT_RESOURCES);
		//context = new FileSystemXmlApplicationContext(CONTEXT_RESOURCES);
		//System.out.println("count: " + context.getBeanDefinitionCount());
		//System.out.println("context: " + context.getBeanDefinitionNames().length);
		//context.refresh();
		//System.out.println("count: " + context.getBeanDefinitionCount());
		//System.out.println("context: " + context.getBeanDefinitionNames().length);
	}
	
	public ApplicationContext getContext() {
		return context;
	}
		
	public PersistenceEngine getPersistenceEngine() {
		return (PersistenceEngine)getContext().getBean(PERSISTENCE_ENGINE);
	}
	
}
