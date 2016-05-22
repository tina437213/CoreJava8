package edu.dtorres.corejava8.cp1;

import java.util.Random;

/**
 * 
 * Write a program that produces a random string of letters and digits by
 * generating a random long value and printing it in base 36.
 * 
 * @author diego
 *
 */
public class Ex10 {
	public static void main(String... args) {
		Random generator = new Random();
		long l = generator.nextLong();
		String generated = Long.toString(l, 36);
		String message = "Generated random value: %s, %d";
		// adding length just for fun, it turns out the generated string is
		// between 12 and 14 characters.
		System.out.println(String.format(message, generated, generated.length()));
	}
}
