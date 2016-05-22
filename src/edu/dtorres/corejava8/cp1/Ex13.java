package edu.dtorres.corejava8.cp1;

import java.util.Arrays;

/**
 * Write a program that prints a lottery combination, picking six distinct
 * numbers between 1 and 49. To pick six distinct numbers, start with an array
 * list filled with 1...49. Pick a random index and remove the element. Repeat
 * six times. Print the result in sorted order.
 * 
 * @author diego
 *
 */
public class Ex13 {
	public static void main(String... args) {
		int[] available = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
				26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49 };

		int[] lotteryNumbers = new int[4];

		for (int picked = 0; picked < 4; picked++) {
			int pick = available[(int) (Math.random() * available.length)];
			lotteryNumbers[picked] = pick;
			int[] temp = new int[available.length - 1];
			int occupied = 0;
			for (int i = 0; i < available.length; i++) {
				if (available[i] != pick) {
					temp[occupied++] = available[i];
				}
			}
			available = temp.clone();
		}
		Arrays.sort(lotteryNumbers);
		System.out.println(Arrays.toString(lotteryNumbers));
	}
}
