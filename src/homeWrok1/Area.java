/**
 * Problem 6.	Connected Areas in a Matrix
Let’s define a connected area in a matrix as an area of cells in which there is a path between every two cells. Write a program to find all connected areas in a matrix. On the console, print the total number of areas found, and on a separate line some info about each of the areas – its position (top-left corner) and size. Order the areas by size (in descending order) so that the largest area is printed first. If several areas have the same size, order them by their position, first by the row, then by the column of the top-left corner. So, if there are two connected areas with the same size, the one which is above and/or to the left of the other will be printed first.

 */
package homeWrok1;

public class Area implements Comparable<Area> {
	private int positionX;
	private int positionY;
	private int size;

	public Area(int x, int y, int size) {
		setPositionX(x);
		setPositionY(y);
		setSize(size);
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positiony) {
		this.positionY = positiony;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int compareTo(Area o) {
		if (this.getSize() > o.getSize()) {
			return 1;
		} else if (this.getSize() < o.getSize()) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Position X/Y: " + getPositionX() + "/" + getPositionY()
				+ " size: " + getSize();

	}
}
