package edu.dtorres.corejava8.cp1;

import java.math.BigInteger;

/**
 * 
 * Write a program that computes the factorial (n! = 1 x 2 x 3 x ... x n, using
 * BigInteger. Compute the factorial of 1000.
 * 
 * @author diego
 *
 */
public class Ex06 {

	public static void main(String[] args) {
		BigInteger bi = BigInteger.valueOf(1000);
		System.out.println(String.format("1000! = %d", factorial(bi)));
	}

	private static BigInteger ONE = BigInteger.valueOf(1);
	
	private static BigInteger factorial(BigInteger bi) {
		if (bi.compareTo(BigInteger.valueOf(1)) <= 0)
			return BigInteger.valueOf(1);
		return bi.multiply(factorial(bi.subtract(ONE)));
	}

}
