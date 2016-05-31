package edu.dtorres.corejava8.cp3.ex0102;

/**
 * 1 - Provide an interface Measurable with a method double getMeasure() that
 * measures an object in some way. Make Employee implement Measurable. Provide a
 * method double average(Measurable[] objects) that computes the average
 * measure. Use it to compute the average salary of an array of employees.
 * 
 * 2 - Continue with the preceding exercise and provide a method Measurable
 * largest(Measurable[] objects). Use it to find the name of the employee with
 * the largest salary. Why do you need a cast?
 * 
 * @author diego
 *
 */
public class Program {
	public static void main(String... args) {
		Employee[] employees = new Employee[10];
		employees[0] = new Employee("Employee 1", Math.random()*150_000);
		employees[1] = new Employee("Employee 2", Math.random()*150_000);
		employees[2] = new Employee("Employee 3", Math.random()*150_000);
		employees[3] = new Employee("Employee 4", Math.random()*150_000);
		employees[4] = new Employee("Employee 5", Math.random()*150_000);
		employees[5] = new Employee("Employee 6", Math.random()*150_000);
		employees[6] = new Employee("Employee 7", Math.random()*150_000);
		employees[7] = new Employee("Employee 8", Math.random()*150_000);
		employees[8] = new Employee("Employee 9", Math.random()*150_000);
		employees[9] = new Employee("Employee 10", Math.random()*150_000);

		System.out.printf("Average salary: %.2f, largest from: %s", average(employees),
				((Employee) largest(employees)).getName());
	}

	/**
	 * Average an array of measurable objects
	 * 
	 * @param objects:
	 *            An array of measurable objects.
	 * @return the average of measures.
	 */
	private static double average(Measurable[] objects) {
		if (objects == null || objects.length == 0)
			return 0.0d;
		if (objects.length == 1)
			return objects[0].getMeasure();

		double sumMeasure = 0.0d;
		for (Measurable m : objects) {
			sumMeasure += m.getMeasure();
		}
		return sumMeasure / objects.length;
	}

	/**
	 * Find the largest measurable in the given array.
	 * 
	 * @param objects:
	 *            An array of measurable objects
	 * @return the largest measurable object in the given array.
	 */
	private static Measurable largest(Measurable[] objects) {
		if (objects == null || objects.length == 0)
			return null;
		if (objects.length == 1)
			return objects[0];

		Measurable largest = objects[0];
		for (Measurable m : objects) {
			if (m.getMeasure() > largest.getMeasure()) {
				largest = m;
			}
		}
		return largest;
	}
}
