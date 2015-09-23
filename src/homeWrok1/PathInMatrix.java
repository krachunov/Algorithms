package homeWrok1;

public class PathInMatrix {

	public static void findPath(char[][] matrix, int x, int y, char symbol) {
		 int count = 0;
		int row = x;
		int col = y;
		if (row < 0 || col < 0 || row >= matrix.length
				|| col >= matrix[row].length) {
			return;
		}

		if (matrix[row][col] == 'e') {

			System.out.println("Exit");
			return;
		}
		if (matrix[row][col] != ' ') {
			return;
		}

		System.out.print(symbol);
		matrix[row][col] = 'x';

		findPath(matrix, x, y + 1, 'R');
		findPath(matrix, x + 1, y, 'D');
		findPath(matrix, x, y - 1, 'L');
		findPath(matrix, x - 1, y, 'U');

		matrix[row][col] = ' ';
	}

	public static void main(String[] args) {

		char[][] matrix = { { ' ', ' ', ' ', ' ' }, { ' ', '*', '*', ' ' },
				{ ' ', '*', '*', ' ' }, { ' ', '*', 'e', ' ' },
				{ ' ', ' ', ' ', ' ' } };
		findPath(matrix, 0, 0, 's');
	}
}
