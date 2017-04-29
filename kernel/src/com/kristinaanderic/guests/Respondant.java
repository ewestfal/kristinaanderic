/*
 * Created on Aug 26, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.kristinaanderic.guests;

import com.kristinaanderic.util.Name;

/**
 * @author ewestfal
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Respondant implements java.io.Serializable {
	
	private Name name;
	private Food food;
	
	public Respondant() {}
	
	public Respondant(Name name, Food food) {
		this.name = name;
		this.food = food;
	}
	
	public Name getName() {
		return name;
	}
	
	public void setName(Name name) {
		this.name = name;
	}
		
	public Food getFood() {
		return food;
	}
		
	public void setFood(Food food) {
		this.food = food;
	}
	
}
