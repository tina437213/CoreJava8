package edu.dtorres.corejava8.cp1;

import java.util.Scanner;

/**
 * 
 * Write a program that reads in two numbers between 0 and 65535, stores them in
 * short variables, and computes their unsigned sum, difference, product,
 * quotient, and remainder, without converting them to int.
 * 
 * @author diego
 *
 */
public class Ex07 {

	public static void main(String[] args) {
		// FIXME: Unsigned operations?
		System.out.println("SHORT UNSIGNED INTEGER OPERATIONS");
		System.out.println("              0 to 65535         ");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Write a short integer:");
		short s1 = (short)scanner.nextInt();
		System.out.print("Write another short integer:");
		short s2 = (short)scanner.nextInt();
		scanner.close();
		short sAddition = (short) (s1 + s2);
		short sDiff = s1 > s2 ? (short) (s1 - s2) : (short) (s2 - s1);
		short product = (short) (s1 * s2);
		short quotient = (short)(s1/s2);
		short remainder = (short)(s1%s2);
		
		System.out.println(String.format("Addition: %d", Short.toUnsignedInt(sAddition)));
		System.out.println(String.format("Difference: %d", Short.toUnsignedInt(sDiff)));
		System.out.println(String.format("Product: %d", Short.toUnsignedInt(product)));
		System.out.println(String.format("Quotient: %d", Short.toUnsignedInt(quotient)));
		System.out.println(String.format("Remainder: %d", Short.toUnsignedInt(remainder)));
	}

}
