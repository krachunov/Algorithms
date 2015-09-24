package homeWrok1;

public class ConnectedAreas {
	static int count = 0;
	static char[][] matrix = { { ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' },
			{ ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' },
			{ ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' },
			{ ' ', ' ', ' ', ' ', '*', ' ', '*', ' ', ' ' } };

	public static void findArea(int x, int y) {
		int count = 0;
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
		
		findArea(x, y + 1);
		findArea(x + 1, y);
		findArea(x, y - 1);
		findArea(x - 1, y);

		matrix[row][col] = ' ';

	}
}
