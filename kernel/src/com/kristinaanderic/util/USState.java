package com.kristinaanderic.util;

/**
 * A typesafe enumeration for US states, including state names
 * and abbreviations.
 * 
 * @author Eric Westfall
 */
public class USState implements java.io.Serializable {

    public static USState AL = new USState("ALABAMA", "AL");
    public static USState AK = new USState("ALASKA", "AK");
    public static USState AS = new USState("AMERICAN SAMOA", "AS");
    public static USState AZ = new USState("ARIZONA", "AZ");
    public static USState AR = new USState("ARKANSAS", "AR");
    public static USState CA = new USState("CALIFORNIA", "CA"); 
    public static USState CO = new USState("COLORADO", "CO");
    public static USState CT = new USState("CONNECTICUT", "CT");
    public static USState DE = new USState("DELAWARE", "DE");
    public static USState DC = new USState("DISTRICT OF COLUMBIA", "DC");
    public static USState FM = new USState("FEDERATED STATES OF MICRONESIA", "FM");
    public static USState FL = new USState("FLORIDA", "FL");
    public static USState GA = new USState("GEORGIA", "GA");
    public static USState GU = new USState("GUAM", "GU");
    public static USState HI = new USState("HAWAII", "HI");
    public static USState ID = new USState("IDAHO", "ID");
    public static USState IL = new USState("ILLINOIS", "IL");
    public static USState IN = new USState("INDIANA", "IN");
    public static USState IA = new USState("IOWA", "IA");
    public static USState KS = new USState("KANSAS", "KS");
    public static USState KY = new USState("KENTUCKY", "KY");
    public static USState LA = new USState("LOUISIANA", "LA");
    public static USState ME = new USState("MAINE", "ME");
    public static USState MH = new USState("MARSHALL ISLANDS", "MH");
    public static USState MD = new USState("MARYLAND", "MD");
    public static USState MA = new USState("MASSACHUSETTS", "MA");
    public static USState MI = new USState("MICHIGAN", "MI");
    public static USState MN = new USState("MINNESOTA", "MN");
    public static USState MS = new USState("MISSISSIPPI", "MS");
    public static USState MO = new USState("MISSOURI", "MO");
    public static USState MT = new USState("MONTANA", "MT");
    public static USState NE = new USState("NEBRASKA", "NE");
    public static USState NV = new USState("NEVADA", "NV");
    public static USState NH = new USState("NEW HAMPSHIRE", "NH");
    public static USState NJ = new USState("NEW JERSEY", "NJ");
    public static USState NM = new USState("NEW MEXICO", "NM");
    public static USState NY = new USState("NEW YORK", "NY");
    public static USState NC = new USState("NORTH CAROLINA", "NC");
    public static USState ND = new USState("NORTH DAKOTA", "ND");
    public static USState MP = new USState("NORTHERN MARIANA ISLANDS", "MP");
    public static USState OH = new USState("OHIO", "OH");
    public static USState OK = new USState("OKLAHOMA", "OK");
    public static USState OR = new USState("OREGON", "OR");
    public static USState PW = new USState("PALAU", "PW");
    public static USState PA = new USState("PENNSYLVANIA", "PA");
    public static USState PR = new USState("PUERTO RICO", "PR");
    public static USState RI = new USState("RHODE ISLAND", "RI");
    public static USState SC = new USState("SOUTH CAROLINA", "SC");
    public static USState SD = new USState("SOUTH DAKOTA", "SD");
    public static USState TN = new USState("TENNESSEE", "TN");
    public static USState TX = new USState("TEXAS", "TX");
    public static USState UT = new USState("UTAH", "UT");
    public static USState VT = new USState("VERMONT", "VT");
    public static USState VI = new USState("VIRGIN ISLANDS", "VI");
    public static USState VA = new USState("VIRGINIA", "VA");
    public static USState WA = new USState("WASHINGTON", "WA");
    public static USState WV = new USState("WEST VIRGINIA", "WV");
    public static USState WI = new USState("WISCONSIN", "WI");
    public static USState WY = new USState("WYOMING", "WY");

    public static USState[] STATES =
    {
        AL, AK, AS, AZ, AR, CA, CO, CT, DE, DC, FM, FL, GA, GU, HI, 
        ID, IL, IN, IA, KS, KY, LA, ME, MH, MD, MA, MI, MN, MS, MO, 
        MT, NE, NV, NH, NJ, NM, NY, NC, ND, MP, OH, OK, OR, PW, PA, 
        PR, RI, SC, SD, TN, TX, UT, VT, VI, VA, WA, WV, WI, WY
    };
    
    private final String name;
    private final String abbreviation;

    public USState(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return this.name;
    }
    
    public String getValue() {
    	return getAbbreviation();
    }
	
    public String getAbbreviation() {
        return abbreviation;
    }
	
    public String toString() {
        return name;
    }
	
    public static USState fromValue(String value) {
    	if (value == null || value.equals("")) return null;
    	for (int index = 0; index < STATES.length; index++) {
    		USState state = STATES[index];
    		if (value.equals(state.getName()) || value.equals(state.getAbbreviation())) {
    			return state;
    		}
    	}
    	return null;
    }
    
}