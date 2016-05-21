package edu.dtorres.corejava8.cp1;

import java.util.Scanner;

/**
 * 
 * Using only the conditional operator, write a program that reads three
 * integers and prints the largest. Repeat with Mat.max.
 * 
 * @author diego
 *
 */
public class Ex03 {

	public static void main(String... args) {
		int one = 1, two = 2, three = 3;
		Scanner in = new Scanner(System.in);

		System.out.print("Write an integer:");
		one = in.nextInt();

		System.out.print("Write another integer:");
		two = in.nextInt();

		System.out.print("Write a last integer:");
		three = in.nextInt();

		in.close();
		String msg = "Max of integers (%d, %d & %d): %d";
		System.out.println(String.format(msg, one, two, three, byIf(one, two, three)));
		System.out.println(String.format(msg, one, two, three, byMax(one, two, three)));

	}

	private static int byIf(int one, int two, int three) {
		int largest = one;
		if (two > largest)
			largest = two;
		if (three > largest)
			largest = three;
		return largest;
	}

	private static int byMax(int one, int two, int three) {
		return Math.max(Math.max(one, two), three);
	}

}
