package edu.dtorres.corejava8.cp2.ex05060708;

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
 * @author diego
 *
 */
public class Point {
	float x, y;

	public Point() {
		x = 0;
		y = 0;
	}

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Point translate(float x, float y) {
		Point p = new Point(this.x + x, this.y + y);
		return p;
	}

	public Point scale(float scale) {
		Point p = new Point(this.x * scale, this.y * scale);
		return p;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public static void main(String[] args) {
		Point p = new Point(3, 4).translate(1, 3).scale(0.5f);
		System.out.printf("x:%.2f, y:%.2f", p.getX(), p.getY());
	}
}
