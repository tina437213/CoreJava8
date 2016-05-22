package edu.dtorres.corejava8.cp1;

import java.util.Scanner;

/**
 * 
 * Write a program that reads an integer and prints it in binary, octal and
 * hexadecimal. Print the reciprocal as hexadecimal floating-pint number.
 * 
 * @author diego
 *
 */
public class Ex01 {

	public static void main(String... args) {
		System.out.print("Please provide an integer: ");
		Scanner in = new Scanner(System.in);
		Integer i = in.nextInt();
		in.close();
		// Calculate reciprocal.
		// + "Hex Float Input: %a \n"
		// Reciprocal = 1/integer
		float reciprocal = 1f/i;
		
		String unformattedMsg = "Decimal Input: %d \n" 
				+ "Binary: %s \n"
				+ "Octal: %o \n" 
				+ "Hex: %X \n" 
				+ "Hex Reciprocal: %a \n"
				+ "END";
		String outputMsg = String.format(unformattedMsg, i, Integer.toBinaryString(i), i, i, reciprocal);

		System.out.println(outputMsg);

	}
}
