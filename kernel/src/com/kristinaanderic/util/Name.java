package com.kristinaanderic.util;

public class Name {

    private String firstName;
    private String middleName;
    private String lastName;
    private Long id;

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

	public Long getId() {
		return id;
	}
    
	public void setId(Long id) {
		this.id = id;
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
        if (argFirstName == null || argFirstName.length() < 1) {
            throw new IllegalArgumentException("First name must be one character or longer.");
        }
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
        if (argLastName == null || argLastName.length() < 1) {
            throw new IllegalArgumentException("Last name must be one character or longer.");
        }
        this.lastName = argLastName;
    }

    public String toString() {
        String middleNameString = getMiddleName();
        if (middleNameString == null) {
            middleNameString = "";
        }
        middleNameString = " "+middleNameString+" ";
        return getFirstName()+middleNameString+getLastName();
    }
    
}
