/*
 * Created on Aug 19, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.kristinaanderic.persistence;

/**
 * @author ewestfal
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface PersistenceEngine {

	/**
	 * Saves or updates the given persistable object to the data store. 
	 * 
	 * @param persistable the persistable to save
	 */
	public void save(Persistable persistable);
	
	/**
	 * Deletes the given persistable object from the data store.
	 * 
	 * @param persistable the persistable to delete
	 */
	public void delete(Persistable persistable);
	
	/**
	 * Loads the given persistable from the database for the given id
	 * and persistable class.  It's important to note that this Persistable
	 * object may not be fully initiated depending on the underlying
	 * implementation of the PersistenceEngine
	 * 
	 * @param id the persistable's identifier in the data store
	 * @param persistableClass the mapped Class of the persistable to be loaded
	 * @return the loaded Persistable object
	 */
	public Persistable load(Long id, Class persistableClass);
	
	public void flush();
	
	public void refresh(Persistable persistable);
	
	/**
	 * This retrieves the underlying persistence engine implementation in case its
	 * needed for advanced features (see implementor's documentation) 
	 * @return
	 */
	public Object getNativeEngine();
	
	//public IdentifierGenerator getIdentifierGenerator();

}
