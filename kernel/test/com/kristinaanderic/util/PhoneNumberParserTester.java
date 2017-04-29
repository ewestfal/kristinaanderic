package com.kristinaanderic.util;

import junit.framework.TestCase;

/**
 * @author Eric Westfall
 * @created Aug 30, 2004
 */
public class PhoneNumberParserTester extends TestCase {

	private String[] validNumbers = 
		new String[] { "8125550999",
				"812-555-0999",
				"812-5550999",
				"812555-0999",
				"(812)555-0999",
				"(812)5550999",
				"(812) 5550999",
				"(812)   555-0999"};

	private String[] invalidNumbers =
		new String[] {
			null,
			"fartpickle",
			"812812812",
			"81281281281"
			};
	
	public PhoneNumberParserTester(String name) {
		super(name);
	}
	
	public void testParsing() {
		for (int index = 0; index < validNumbers.length; index++) {
			PhoneNumber number = PhoneNumberParser.parse(validNumbers[index]);
			verifyNumber(number);
		}
		for (int index = 0; index < invalidNumbers.length; index++) {
			assertNull(PhoneNumberParser.parse(invalidNumbers[index]));
		}
	}
	
	private void verifyNumber(PhoneNumber number) {
		assertNotNull(number);
		assertEquals("812", number.getAreaCode());
		assertEquals("555", number.getPrefix());
		assertEquals("0999", number.getPostfix());
	}
	
}
