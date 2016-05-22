package edu.dtorres.corejava8.cp1;

/**
 * Improve the average method so that it is called with at least one parameter.
 * 
 * @author diego
 *
 */
public class Ex16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(average(3, 4, 5, 20));
	}

	public static double average(double value1, double... values) {
		double sum = value1;
		for (double v : values)
			sum += v;
		return sum / (values.length + 1);
	}

}
