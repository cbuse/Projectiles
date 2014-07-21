package Shapes;

/**
 * Coordonate in the screen region
 */
public class Point {
	private int x, y;
	
	public Point(int x, int y) {
		this.x	= x;
		this.y	= y;
	}
	
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	

	/**
	 * Gives the resulting point by translating the current one
	 * 
	 * @param x	translate distance on X axis
	 * @param y	translate distance on Y axis
	 * @return	the point at the given location
	 */
	public Point translate(int x, int y) {
		return new Point(this.x+x, this.y+y);

	}
	
	/**
	 * Moves the current point.
	 * 
	 * @param x translate distance on X axis
	 * @param y translate distance on Y axis
	 * @return the new coordinates of the currents point
	 */
	public Point trans(int x, int y) {
		this.x = this.x + x;
		this.y = this.y + y;

		return this;
	}
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
