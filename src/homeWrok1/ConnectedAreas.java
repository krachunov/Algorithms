/**
 * Problem 6.	Connected Areas in a Matrix
Let’s define a connected area in a matrix as an area of cells in which there is a path between every two cells. Write a program to find all connected areas in a matrix. On the console, print the total number of areas found, and on a separate line some info about each of the areas – its position (top-left corner) and size. Order the areas by size (in descending order) so that the largest area is printed first. If several areas have the same size, order them by their position, first by the row, then by the column of the top-left corner. So, if there are two connected areas with the same size, the one which is above and/or to the left of the other will be printed first.

 */
package homeWrok1;

import java.util.ArrayList;
import java.util.List;

public class ConnectedAreas {
	static int count = 0;
	static List<Area> listAreas = new ArrayList<Area>();
	static char[][] matrix = { { ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' },
			{ ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' },
			{ ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' },
			{ ' ', ' ', ' ', ' ', '*', ' ', '*', ' ', ' ' } };

	public static void discoveryLab() {
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[0].length; y++) {
				if (x >= matrix.length || y >= matrix[x].length) {
					continue;
				}
				if (matrix[x][y] == ' ') {
					findArea(x, y);
					listAreas.add(new Area(x, y, count));
					count = 0;
				}
			}
		}
	}

	public static void findArea(int x, int y) {

		int row = x;
		int col = y;

		if (row < 0 || col < 0 || row >= matrix.length
				|| col >= matrix[row].length) {
			return;
		}

		if (matrix[row][col] != ' ') {
			return;
		}

		matrix[row][col] = 'x';
		count++;

		findArea(x, y + 1);
		findArea(x + 1, y);
		findArea(x, y - 1);
		findArea(x - 1, y);

	}

	public static void main(String[] args) {
		discoveryLab();

		for (Area element : listAreas) {
			System.out.println(element.toString());
		}
	}
}
