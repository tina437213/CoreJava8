package edu.dtorres.corejava8.cp2.ex05;

/**
 * 05 - Implement an immutable class Point that describes a point in the plane.
 * Provide a constructor to set it to a specific point, a no-argument
 * constructor to set it to the origin, and methods getX, getY, translate, and
 * scale. The translate method moves the point by a given amount in x- and
 * y-direction. The scale method scales both coordinates by a given factor.
 * Implement these methods so that they return new points with the results. For
 * example,
 * 
 * Point p = new Point(3, 4).translate(1, 3).scale(0.5);
 * 
 * should set p to a point with coordinates (2, 3.5)
 * 
 * 07 - Add javadoc comments to the Point class from the preceding exercises.
 * 
 * @author diego
 *
 */
public class Point {
	float x, y;

	/**
	 * Point constructor for origin coordinates.
	 */
	public Point() {
		x = 0;
		y = 0;
	}

	/**
	 * Point constructor with initial position.
	 * 
	 * @param x
	 * @param y
	 */
	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Add the given x and y axis to the current point coordinates.
	 * 
	 * @param x
	 * @param y
	 * @return a new Point instance with the given translated coordinates.
	 */
	public Point translate(float x, float y) {
		Point p = new Point(this.x + x, this.y + y);
		return p;
	}

	/**
	 * Scale a point to the given level.
	 * 
	 * @param scale
	 * @return a new scaled Point instance.
	 */
	public Point scale(float scale) {
		Point p = new Point(this.x * scale, this.y * scale);
		return p;
	}

	/**
	 * Get the x axis value.
	 * 
	 * @return
	 */
	public float getX() {
		return x;
	}

	/**
	 * get the Y axis value.
	 * 
	 * @return
	 */
	public float getY() {
		return y;
	}

	/**
	 * Program main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Point p = new Point(3, 4).translate(1, 3).scale(0.5f);
		System.out.printf("x:%.2f, y:%.2f", p.getX(), p.getY());
	}
}
