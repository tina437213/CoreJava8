package edu.dtorres.corejava8.cp1;

import java.util.Scanner;

/**
 * 
 * Write a program that reads an integer angle (which may be positive or
 * negative) and normalizes it to a value between 0 and 359 degrees. Try it
 * first with the % operator, then with floorMod.
 * 
 * @author diego
 *
 */
public class Ex02 {

	public static void main(String... args) {
		// normalize. If I enter a value like 718 = 358
		System.out.println("ANGLE NORMALIZATION.");
		System.out.print("please provide an integer: ");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		scanner.close();
		int angle = Math.abs(i == 0 ? 0 : i % 360);
		int angleFloorMod = Math.abs(i == 0 ? 0 : Math.floorMod(i, 360));

		System.out.println(String.format("normalized: %d", angle));
		System.out.println(String.format("normalized with floorMod: %d", angleFloorMod));
	}
}
