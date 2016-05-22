package edu.dtorres.corejava8.cp1;

import java.util.Scanner;

/**
 * Write a program that reads a line of text and prints all characters that are
 * not ASCII, together with their Unicode values.
 * 
 * @author diego
 *
 */
public class Ex11 {
	public static void main(String... args) {
		System.out.println("String ASCII analyzer.");
		System.out.println("Write a string:");
		Scanner scanner = new Scanner(System.in);
		String received = scanner.nextLine();
		for (int i = 0; i < received.length(); i++) {
			char c = received.charAt(i);
			int codePoint = received.codePointAt(received.offsetByCodePoints(0, i));
			if (codePoint > 127) {
				String message = "Hey! this is not ASCII: %c, (%d)";
				System.out.println(String.format(message, c, codePoint));
			}

		}
		scanner.close();
	}
}
