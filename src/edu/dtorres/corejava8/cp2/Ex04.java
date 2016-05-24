package edu.dtorres.corejava8.cp2;

import org.omg.CORBA.IntHolder;

/**
 * Why can't you implement a Java method that swaps the contents of two int
 * variables? Instead, write a method that swaps the contents of two IntHolder
 * objects. (Look up this rather obscure class in the API documentation.) Can
 * you swap the contents of two Integer objects?
 * 
 * @author diego
 *
 */
public class Ex04 {
	public static void main(String... args) {
		IntHolder a = new IntHolder(5);
		IntHolder b = new IntHolder(10);

		// You can't SWAP int values because they are not a value to a reference
		// of an object, they are fixed values in the VM.
		System.out.println("A: " + a.value);
		System.out.println("B: " + b.value);

		swap(a, b);

		System.out.println("----------------");
		System.out.println("A: " + a.value);
		System.out.println("B: " + b.value);

		swapInteger(a.value, b.value);

		System.out.println("----------------");
		System.out.println("A: " + a.value);
		System.out.println("B: " + b.value);
	}

	public static void swap(IntHolder a, IntHolder b) {
		int temp = a.value;
		a.value = b.value;
		b.value = temp;
	}

	/**
	 * You can't SWAP Integer values.
	 * 
	 * @param a
	 * @param b
	 */
	public static void swapInteger(Integer a, Integer b) {
		int temp = a.intValue();
		a = b.intValue();
		b = temp;
	}
}
