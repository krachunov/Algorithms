/**
 * Problem 2.	Areas in Matrix
We are given a matrix of letters of size N * M. Two cells are neighbor if they share a common wall.
Write a program to find the connected areas of neighbor cells holding the same letter.
Display the total number of areas and the number of areas for each alphabetical letter. 
 */
package homeWork5;

import homeWork1.Area;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AreasInMatrix {
	static int count = 0;
	static List<Area> listAreas = new ArrayList<Area>();

	static class Area implements Comparator<Area> {
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
		public String toString() {
			return "Position X/Y: " + getPositionX() + "/" + getPositionY()
					+ " size: " + getSize();

		}

		@Override
		public int compare(Area o1, Area o2) {
			if (o1.getSize() > o2.getSize()) {
				return -1;
			} else if (o1.getSize() < o2.getSize()) {
				return 1;
			} else {
				if (o1.getPositionX() > o2.getPositionX()) {
					return -1;
				} else if (o1.getPositionY() < o2.getPositionY()) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}

	static char[][] matrix = { { ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' },
			{ ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' },
			{ ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' },
			{ ' ', ' ', ' ', ' ', '*', ' ', '*', ' ', ' ' } };

	static char[][] matrix2 = {
			{ '*', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ', ' ' },
			{ '*', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ', ' ' },
			{ '*', ' ', ' ', '*', '*', '*', '*', '*', ' ', ' ' },
			{ '*', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ', ' ' },
			{ '*', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ', ' ' } };

	public static void discoveryLab(char[][] matrixLab) {
		for (int x = 0; x < matrixLab.length; x++) {
			for (int y = 0; y < matrixLab[0].length; y++) {
				if (x >= matrixLab.length || y >= matrixLab[x].length) {
					continue;
				}
				if (matrixLab[x][y] == ' ') {
					findArea(matrixLab, x, y);
					listAreas.add(new Area(x, y, count));
					count = 0;
				}
			}
		}
	}

	private static void findArea(char[][] matrixLab, int x, int y) {

		int row = x;
		int col = y;

		if (row < 0 || col < 0 || row >= matrixLab.length
				|| col >= matrixLab[row].length) {
			return;
		}

		if (matrixLab[row][col] != ' ') {
			return;
		}

		matrixLab[row][col] = 'x';
		count++;

		findArea(matrixLab, x, y + 1);
		findArea(matrixLab, x + 1, y);
		findArea(matrixLab, x, y - 1);
		findArea(matrixLab, x - 1, y);

	}

	public static void main(String[] args) {

		// If you want to test with another lab, change argument in method
		// discoveryLab(), with "matrix2"
		discoveryLab(matrix2);

		listAreas.sort(new Comparator<Area>() {

			@Override
			public int compare(Area o1, Area o2) {
				if (o1.getSize() > o2.getSize()) {
					return -1;
				} else if (o1.getSize() < o2.getSize()) {
					return 1;
				} else {
					if (o1.getPositionX() > o2.getPositionX()) {
						return -1;
					} else if (o1.getPositionY() < o2.getPositionY()) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		});
		for (Area element : listAreas) {
			System.out.println(element.toString());
		}
	}
}
