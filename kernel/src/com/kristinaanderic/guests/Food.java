/*
 * Created on Aug 14, 2004
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.kristinaanderic.guests;

/**
 * @author ewestfal
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class Food implements java.io.Serializable {

	private static final String BEEF_VALUE = "BEEF";
	private static final String CHICKEN_VALUE = "CHICKEN";
	private static final String CHILD_VALUE = "CHILD";
	private static final String PASTA_VALUE = "PASTA";
	private static final String PORK_VALUE = "PORK";
	private static final String NONE_VALUE = "NONE";
	
	public static final Food BEEF = new Food(BEEF_VALUE);
	public static final Food CHICKEN = new Food(CHICKEN_VALUE);
	public static final Food CHILD = new Food(CHILD_VALUE);
	public static final Food PASTA = new Food(PASTA_VALUE);
	public static final Food PORK = new Food(PORK_VALUE);
	public static final Food NONE = new Food(NONE_VALUE);
	
	private static final Food[] FOOD = 
		new Food[]{ BEEF, CHICKEN, CHILD, PASTA, PORK, NONE };

	private final String value;
	
	private Food(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
    
        public String toString() {
                return getValue();
        }

	public static Food[] getFood() {
		return FOOD;
	}
	
	public static Food fromValue(String value) {
		for (int index = 0; index < getFood().length; index++) {
			if (getFood()[index].getValue().equals(value)) {
				return getFood()[index];
			}
		}
		return null;
	}
	
}
