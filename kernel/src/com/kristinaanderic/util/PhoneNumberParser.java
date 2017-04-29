package com.kristinaanderic.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Eric Westfall
 * @created Aug 24, 2004
 */
public class PhoneNumberParser {
	
	private static final Pattern phoneNumberPattern = Pattern.compile("^\\(?(\\d{3})\\)?(\\s*|-?)(\\d{3})-?(\\d{4})$");

	
	public static PhoneNumber parse(String phoneNumber) {
		if (phoneNumber == null) return null;
		PhoneNumber number = null;
		Matcher matcher = phoneNumberPattern.matcher(phoneNumber);
		if (matcher.matches()) {
			String areaCode = matcher.group(1);
			String prefix = matcher.group(3);
			String postfix = matcher.group(4);
			number = new PhoneNumber(areaCode, prefix, postfix);
		}
		return number;
	}
	
}
