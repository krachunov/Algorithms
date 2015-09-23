/**
 * Problem 5.	Paths between Cells in Matrix
We are given a matrix of passable and non-passable cells. Write a recursive program for finding all paths between two cells in the matrix. The matrix can be represented by a two-dimensional char array or a string array, passable cells are represented by a space (' '), non-passable cells are represented by asterisks ('*'), the start cell is represented by the symbol 's' and the exit cell is represented by 'e'. Movement is allowed in all four directions (up, down, left, right) and a cell can be passed only once in a given path.
Print on the console all paths and on the last line the count of paths found. You can represent the directions with symbols, e.g. 'D' for down, 'U' for up, etc. The ordering of the paths is not relevant.
Examples:
Let’s consider the following layout:

 */
package homeWrok1;

import java.util.ArrayList;
import java.util.List;

public class PathInMatrix {
	static List<Character> dir = new ArrayList<Character>();

	static void printDir() {

		for (Character character : dir) {
			System.out.print(character);
		}
	}

	public static void findPath(char[][] matrix, int x, int y, char symbol) {
		int count = 0;
		int row = x;
		int col = y;
		if (row < 0 || col < 0 || row >= matrix.length
				|| col >= matrix[row].length) {
			return;
		}

		if (matrix[row][col] == 'e') {

			printDir();
			System.out.println();
			System.out.println("Exit");
			return;
		}
		if (matrix[row][col] != ' ') {
			return;
		}

		System.out.print(symbol);
		matrix[row][col] = 'x';
		dir.add(symbol);
		findPath(matrix, x, y + 1, 'R');
		findPath(matrix, x + 1, y, 'D');
		findPath(matrix, x, y - 1, 'L');
		findPath(matrix, x - 1, y, 'U');

		matrix[row][col] = ' ';
		dir.remove(dir.size() - 1);
	}

	public static void main(String[] args) {

		char[][] matrix = { { ' ', ' ', ' ', ' ' }, { ' ', '*', '*', ' ' },
				{ ' ', '*', '*', ' ' }, { ' ', '*', 'e', ' ' },
				{ ' ', ' ', ' ', ' ' } };
		findPath(matrix, 0, 0, 's');
	}
}
