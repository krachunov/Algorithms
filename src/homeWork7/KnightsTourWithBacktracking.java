/**
 * @author dim4o
 */

package homeWork7;

class KnightsTourWithBacktracking {
	private static int[] directions = { 1, 2, -1, 2, 2, 1, 1, -2, -1, -2, -2,
			1, 2, -1, -2, -1 };

	public static void main(String[] args) {
		int size = 5;
		int[][] board = new int[size][size];
		startKnightTour(board, 0, 0, 1);
	}

	private static void startKnightTour(int[][] board, int row, int col,
			int step) {
		board[row][col] = step;
		if (step == board.length * board.length) {
			printBoard(board);
			return;
		}

		for (int i = 0; i < directions.length; i += 2) {
			int currentRow = row + directions[i];
			int currentCol = col + directions[i + 1];
			if (isInBounds(currentRow, currentCol, board.length)
					&& board[currentRow][currentCol] == 0) {
				startKnightTour(board, currentRow, currentCol, step + 1);
			}
		}

		board[row][col] = 0;
	}

	private static boolean isInBounds(int row, int col, int size) {
		return !(row >= size || col >= size || row < 0 || col < 0);
	}

	private static void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}