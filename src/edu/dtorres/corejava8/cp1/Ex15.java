package edu.dtorres.corejava8.cp1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a program that stores Pascal's triangle up to a given n in an
 * ArrayList<ArrayList<Integer>>.
 * 
 * @author diego
 *
 */
public class Ex15 {
	public static void main(String[] args) {
		System.out.println("***** PASCAL TRIANGLE WITH ArrayLists *****");
		System.out.print("How many rows?:");
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		scanner.close();
		
		// Build the triangle
		ArrayList<ArrayList<Integer>> pascal = new ArrayList<>();
		for(int i = 0; i < length; i++){
			pascal.add(new ArrayList<Integer>());
			pascal.get(i).add(1);
			for(int j = 1; j < i; j++){
				pascal.get(i).add(pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j));
			}
			pascal.get(i).add(1);
		}
		
		// Print the triangle
		for(ArrayList<Integer> row : pascal){
			for(Integer element : row){
				System.out.printf("%4d", element);
			}
			System.out.println();
		}
	}
}
