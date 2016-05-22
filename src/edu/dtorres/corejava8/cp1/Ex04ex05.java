package edu.dtorres.corejava8.cp1;

/**
 * 
 * Write a program that prints the smallest and largest positive double value.
 * Hint: Look up Math.nextUp in the Java API
 * 
 * @author diego
 *
 */
public class Ex04ex05 {
	public static void main(String[] args) {
		System.out.println(String.format("Min double: %e", Double.MIN_VALUE));
		System.out.println(String.format("Max double: %e", Double.MAX_VALUE));
		int i = (int) Double.MAX_VALUE;
		System.out.println(String.format("Casted int: %d, maxInt: %d", i, Integer.MAX_VALUE));
		// Observation: Information lost.
	}
}
