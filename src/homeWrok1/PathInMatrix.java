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
