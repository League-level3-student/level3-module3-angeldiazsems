package _00_Intro_To_String_Methods;

import java.util.Arrays;
import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		int length1 = s1.length();
		int length2 = s2.length();
		if (length1 > length2) {
			return s1;
		} else {
			return s2;
		}

	}

	// If String s contains the word "underscores", change all of the spaces
	// to underscores
	public static String formatSpaces(String s) {
		if (s.contains("underscores")) {
			s = s.replace(' ', '_');
		}
		return s;
	}

	// Return the name of the person whose LAST name would appear first if they
	// were in alphabetical order.
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		s1 = s1.trim();
		s2 = s2.trim();
		s3 = s3.trim();
		// get rid of extra space^

		String First[] = s1.split(" ");
		String Second[] = s2.split(" ");
		String Third[] = s3.split(" ");

		if (First[1].compareTo(Second[1]) < 0 && First[1].compareTo(Third[1]) < 0) {
			return s1;
		} else if (Second[1].compareTo(First[1]) < 0 && Second[1].compareTo(Third[1]) < 0) {
			return s2;
		} else if (Third[1].compareTo(First[1]) < 0 && Third[1].compareTo(Second[1]) < 0) {
			return s3;
		} else {
			return null;
		}

	}

	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int sum = 0;
		char[] charArr = s.toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			boolean check = Character.isDigit(charArr[i]);
			if (check) {
				sum += Character.getNumericValue(charArr[i]);
			}
		}

		return sum;
	}

	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		String removed = s.replace(substring, "");
		// Make a string that has everything except the substring
		int count = (s.length() - removed.length()) / substring.length();
		// With the new String, subtract its length to the orignal Strings length
		// Once you get some number, divide it by the substrings length
		// From that you can see how many times the subtring is in there

		return count;
	}

	// Call Utilities.encrypt at the bottom of this file to encrypt String s
	public static String encrypt(String s, char key) {
		byte[] bite = s.getBytes();
		byte bight = (byte) key;
		String e = Utilities.encrypt(bite, bight);
		return e;
	}

	// Call Utilities.decrypt at the bottom of this file to decrypt the
	// cyphertext (encrypted text)
	public static String decrypt(String s, char key) {

		byte bight = (byte) key;
		String e = Utilities.decrypt(s, bight);
		return e;
	}

	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int count = 0;
		String[] words = s.split(" ");
		for (int i = 0; i < words.length; i++) {
			if (words[i].contains(substring) && words[i].endsWith(substring)) {
				count++;
			}
		}
		return count;
	}

	// Given String s, return the number of characters between the first
	// occurrence of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		int firstIndex = s.indexOf(substring);
		firstIndex = firstIndex + substring.length() - 1;
		// ^making it so firstIndex is the index of the last letter
		// of the substring, instead of the first letter
		
		int distance = 0;
		int lastIndex = s.lastIndexOf(substring);
		char[] ch = s.toCharArray();
		for(int i = firstIndex+1; i < lastIndex; i++) {
			distance++;
		}
		System.out.println("First :" + firstIndex);
		System.out.println("Last :" + lastIndex);
		System.out.println("Distance :" + distance);

		return distance; 
	}

	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		s = s.trim();
		s = s.replace (".", "");
		s = s.replace("?", "");
		s = s.replace("!", "");
		s = s.replace(":", "");
		s = s.replace("-", "");
		s = s.replace(",", "");
		s = s.replace(" ", "");
		s = s.toLowerCase();
		
		String normal = s;
		String backward = "";
		for(int i = normal.length()-1; i >= 0; i--) {
			backward+=normal.charAt(i);
			
		}
		System.out.println("Backward: "+backward);
		System.out.println("Forward: "+normal);

		
		
		if(normal.equals(backward)) {
			return true;

		}
		return false;
	}
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a
	// single byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
