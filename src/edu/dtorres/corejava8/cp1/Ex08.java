package edu.dtorres.corejava8.cp1;

import java.util.Scanner;

/**
 * 
 * Write a program that reads an String and prints all of its nonempty
 * substrings
 * 
 * @author diego
 *
 */
public class Ex08 {

	public static void main(String[] args) {
		System.out.println("String splitter. All nonempty strings from input");
		System.out.print("Separate words from this string:");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		scanner.close();
		String[] splitted = s.split(" ");
		System.out.println(splitted.length + " words detected.");
		for (String split : splitted) {
			if (!"".equals(split.trim()))
				System.out.println(split);
		}
	}

}
