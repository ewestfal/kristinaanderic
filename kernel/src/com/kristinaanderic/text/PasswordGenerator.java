package com.kristinaanderic.text;

/**
 * This class generates random passwords based on the theory
 * that consonant-vowel-consonant triplets in the English 
 * language are all easly pronouncable (with the exception of
 * the letters q and y)
 * 
 * @author Eric Westfall
 */
public class PasswordGenerator implements Generator {
	
	private static final char[] VOWELS = 
		new char[] { 'a', 'e', 'i', 'o', 'u' };
	private static final char[] CONSONANTS =
		new char[] { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'r', 's', 't', 'v', 'w', 'x', 'z' };
	
	public String generate(int length) {
		int fragments = length / 3;
		int remainder = length % 3;
		return generateFragments(fragments)+generateRemainder(remainder);
	}
	
	private String generateFragments(int fragments) {
		StringBuffer buffer = new StringBuffer();
		for (int index = 0; index < fragments; index++) {
			buffer.append(generateFragment());
		}
		return buffer.toString();
	}
	
	private String generateFragment() {
		StringBuffer fragment = new StringBuffer();
		fragment.append(pick(CONSONANTS));
		fragment.append(pick(VOWELS));
		fragment.append(pick(CONSONANTS));
		return fragment.toString();
	}
	
	private char pick(char[] characters) {
		return characters[(int)(Math.random() * characters.length)];
	}
	
	private String generateRemainder(int remainder) {
		StringBuffer buffer = new StringBuffer();
		for (int index = 0; index < remainder; index++) {
			buffer.append((int)(Math.random()*10));
		}
		return buffer.toString();
	}
	
}
