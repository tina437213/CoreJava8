package edu.dtorres.corejava8.cp2.ex09;

/**
 * Implement a class Car that models a car traveling along the x.axis, consuming
 * gas as it moves. Provide methods to drive by a given number of miles, to add
 * a given number of gallons to the gas tank, and to get the current distance
 * from the origin and fuel level. Specify the fuel efficiency (in
 * miles/gallons) in the constructor. Should this be an immutable class? Why or
 * why not?
 * 
 * In my opinion, this should not be an immutable class, because we need to
 * store state on the distance and available gas for a given object instance.
 * 
 * @author diego
 *
 */
public class Car {
	private float miles = 0.0f;
	private float gasGallons = 0.0f;
	private float efficiency = 0.0f;

	public static void main(String... args) {
		Car car = new Car(2.5f);
		try {
			car.addGas(80f);
		} catch (InsufficientGasException e) {
			e.printStackTrace();
		}
		try {
			car.travel(25f);
		} catch (InsufficientGasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("I have traveled %.2f miles, and I have %.2f gas gallons in my tank.", car.getMiles(),
				car.getGas());
	}

	/**
	 * Create a car instance with a given efficiency in miles/gallon
	 * 
	 * @param efficiency
	 */
	public Car(float efficiency) {
		this.efficiency = efficiency;
	}

	/**
	 * You can add and remove gallons from this instance.
	 * 
	 * @param gallons
	 */
	public void addGas(float gallons) throws InsufficientGasException {
		if (gasGallons + gallons < 0) {
			String errMessage = "I can't give you %f gallons of gas, I only have %.2f gallons in my tank.";
			throw new InsufficientGasException(String.format(errMessage, gallons, gasGallons));
		}
		gasGallons += gallons;
	}

	/**
	 * You can travel only forward, not backwards. (only possitive miles).
	 * 
	 * @param miles
	 * @throws InsufficientGasException
	 */
	public void travel(float miles) throws InsufficientGasException {
		if (miles < 0) {
			throw new IllegalArgumentException("Can't travel negative miles.");
		}
		float gasCost = miles * efficiency * -1;
		try {
			addGas(gasCost);
			this.miles += miles;
		} catch (InsufficientGasException e) {
			throw new InsufficientGasException("I can't drive that far with the amount of gas in my tank.", e);
		}
	}

	public float getMiles() {
		return miles;
	}

	public float getGas() {
		return gasGallons;
	}

	private class InsufficientGasException extends Exception {
		private static final long serialVersionUID = -5060310150738935544L;

		public InsufficientGasException(String message) {
			super(message);
		}

		public InsufficientGasException(String message, Throwable e) {
			super(message, e);
		}
	}
}
