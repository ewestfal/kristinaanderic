package com.kristinaanderic.persistence;

import com.kristinaanderic.core.Kernel;

/**
 * Basic implementation and super class for Persistable classes.
 * 
 * @author Eric Westfall
 * @created Aug 19, 2004
 */
public abstract class AbstractPersistable implements Persistable {

	private Long id;

	public AbstractPersistable() {}

	public AbstractPersistable(Long id) {
		setId(id);
	}

	public Long getId() {
		return id;
	}
	
	protected void setId(Long id) {
		this.id = id;
	}

	public void save() {
		Kernel.getCore().getPersistenceEngine().save(this);
	}
	
	public int hashCode() {
		if (id == null) return super.hashCode();
		return id.hashCode();
	}
	
	public boolean equals(Object object) {
		if (id == null) return super.equals(object);
		if (object instanceof Persistable) {
			return id.equals(((Persistable)object).getId());
		}
		return false;
	}
	
	public String toString() {
		return super.toString()+" "+getId();
	}

}
