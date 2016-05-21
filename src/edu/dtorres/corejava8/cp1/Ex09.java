package edu.dtorres.corejava8.cp1;

/**
 * 
 * Section 1.5.3, "String Comparison", on p. 21 has an example of two strings s
 * and t so that s.equals(t) but s!=t. Come up with a different example that
 * doesn't use substring.
 * 
 * @author diego
 *
 */
public class Ex09 {
	/**
	 * Computing same string from different objects, so == operator is false,
	 * but String.equals() method returns true.
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		String s = new String("Hello");
		String t = new String("Hello");

		System.out.println(s == t);
		System.out.println(s.equals(t));
	}
}
