package edu.dtorres.corejava8.cp1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a program that reads a two-dimensional array of integers and determines
 * whether it is a magic square (that is, whether the sum of all rows, all
 * columns, and the diagonals is the same). Accept lines of input that you break
 * up into individual integers, and stop when the user enters a blank line. For
 * example, with the input:
 * 
 * 16 3 2 13 
 * 3 10 11 8 
 * 9 6 7 12 
 * 4 15 14 1 
 * (Blank line)
 * 
 * Your program should respond affirmatively.
 * 
 * NOTE: The given numbers from the book they are not a magic square.
 * The second row adds to 32 while the other rows add to 34.
 * A 34 magic square is:
 * 14 1 12 7
 * 11 8 13 12
 * 5 10 3 16
 * 4 15 6 9
 * 
 * (watch: https://www.youtube.com/watch?v=NVx9xfOl10o)
 * 
 * @author diego
 *
 */
public class Ex14 {
	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);
		String line = null;
		System.out.print("Write here:");
		ArrayList<int[]> lines = new ArrayList<>();
		while (!"".equals((line = scanner.nextLine()))) {
			System.out.print("Write here:");
			lines.add(processLine(line));
		}
		scanner.close();
		System.out.println("result: " + isMagic(lines));
	}

	private static int[] processLine(String line) {
		String[] splitted = line.split(" ");
		int[] result = new int[splitted.length];
		for (int i = 0; i < splitted.length; i++) {
			result[i] = Integer.parseInt(splitted[i]);
		}
		return result;
	}

	private static boolean isMagic(ArrayList<int[]> lines) {
		int[] diagonal = new int[lines.size()];
		int[] inverseDiagonal = new int[lines.size()];
		int rowAdd = 0;
		for (int i = 0; i < lines.size(); i++) {
			int[] line = lines.get(i);
			// if its not square, then is not magic square
			// to be an square it must have the same number of lines and columns
			if (line.length != lines.size())
				return false;

			if (rowAdd == 0) {
				rowAdd = addRow(line);
				System.out.println("Are the lines and diagonals adding to " + rowAdd + "?");
			} else if (rowAdd != addRow(line))
				return false;

			diagonal[i] = line[i];
			inverseDiagonal[lines.size() - i - 1] = line[lines.size() - i - 1];
		}

		if (rowAdd != addRow(diagonal))
			return false;
		if (rowAdd != addRow(inverseDiagonal))
			return false;

		return true;
	}

	private static int addRow(int[] row) {
		int result = 0;
		for (int i : row) {
			result += i;
		}
		return result;
	}
}
