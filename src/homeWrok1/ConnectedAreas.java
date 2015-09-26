/**
 * Problem 6.	Connected Areas in a Matrix
Let’s define a connected area in a matrix as an area of cells in which there is a path between every two cells. Write a program to find all connected areas in a matrix. On the console, print the total number of areas found, and on a separate line some info about each of the areas – its position (top-left corner) and size. Order the areas by size (in descending order) so that the largest area is printed first. If several areas have the same size, order them by their position, first by the row, then by the column of the top-left corner. So, if there are two connected areas with the same size, the one which is above and/or to the left of the other will be printed first.

 */
package homeWrok1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConnectedAreas {
	static int count = 0;
	static List<Area> listAreas = new ArrayList<Area>();
	static char[][] matrix = { { ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' },
			{ ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' },
			{ ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' },
			{ ' ', ' ', ' ', ' ', '*', ' ', '*', ' ', ' ' } };

	static char[][] matrix2 = {
			{ '*', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' , ' '},
			{ '*', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ', ' ' },
			{ '*', ' ', ' ', '*', '*', '*', '*', '*', ' ' , ' '},
			{ '*', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' , ' '},
			{ '*', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' , ' '}};

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
		
		//If you want to test with another lab, change argument in method discoveryLab(), with "matrix2"
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
