package com.kristinaanderic.util;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.kristinaanderic.persistence.AbstractPersistable;

public class Name extends AbstractPersistable {

    private String firstName;
    private String middleName;
    private String lastName;

	public Name() {
		this("", "", "");
	}

	public Name(String firstName,
				 String lastName) {
		this(firstName, "", lastName);				 		
	}

    public Name(String firstName,
                String middleName,
                String lastName) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
    }

    /**
     * Gets the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName()  {
        return this.firstName;
    }

    /**
     * Sets the value of firstName
     *
     * @param argFirstName Value to assign to this.firstName
     */
    public void setFirstName(String argFirstName) {
        this.firstName = argFirstName;
    }

    /**
     * Gets the value of middleName
     *
     * @return the value of middleName
     */
    public String getMiddleName()  {
        return this.middleName;
    }

    /**
     * Sets the value of middleName
     *
     * @param argMiddleName Value to assign to this.middleName
     */
    public void setMiddleName(String argMiddleName) {
        this.middleName = argMiddleName;
    }

    /**
     * Gets the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName()  {
        return this.lastName;
    }

    /**
     * Sets the value of lastName
     *
     * @param argLastName Value to assign to this.lastName
     */
    public void setLastName(String argLastName) {
        this.lastName = argLastName;
    }

    public String toString() {
        String middleNameString = getMiddleName();
        if (middleNameString == null || middleNameString.equals("")) {
            middleNameString = " ";
        }
        if (!middleNameString.equals(" ")) {
            middleNameString = " "+middleNameString+" ";
        }
        return getFirstName()+middleNameString+getLastName();
    }
    
    public boolean equals(Object object) {
    	boolean isEquals = false;
    	if (object instanceof Name) {
    		Name name = (Name)object;
    		isEquals = new EqualsBuilder().append(firstName, name.getFirstName()).
				append(middleName, name.getMiddleName()).
				append(lastName, name.getLastName()).isEquals();
    	}
    	return isEquals; 
    }
    
    public int hashCode() {
    	return new HashCodeBuilder().append(firstName).
			append(middleName).append(lastName).hashCode();
    }
    
}
