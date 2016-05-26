package edu.dtorres.corejava8.cp2.ex06;

/**
 * 06 - Repeat the preceding example, but now make translate and scape methods
 * into mutators.
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
	 * increase the x and y axis in the given x and y translated coordinates.
	 * @param x
	 * @param y
	 * @return the transformed Point instance
	 */
	public Point translate(float x, float y) {
		this.x += x;
		this.y += y;
		return this;
	}

	/**
	 * Scale the Point instance in the given scale value.
	 * @param scale
	 * @return the scaled Point instance.
	 */
	public Point scale(float scale) {
		this.x *= scale;
		this.y *= scale;
		return this;
	}

	/**
	 * Get the x axis value.
	 * @return
	 */
	public float getX() {
		return x;
	}

	/**
	 * get the y axis value.
	 * @return
	 */
	public float getY() {
		return y;
	}

	/**
	 * Main program method.
	 * @param args
	 */
	public static void main(String[] args) {
		Point p = new Point(3, 4).translate(1, 3).scale(0.5f);
		System.out.printf("x:%.2f, y:%.2f", p.getX(), p.getY());
	}
}
