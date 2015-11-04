/**
 * Problem 3. Knight’s Tour
Given a board of size NxN (a standard square matrix), a chess knight can perform a tour of the board, visiting each cell only once.
The knight moves according to the rules of chess (in an L-shaped pattern) and starts from the upper-left corner.
Write a program which finds and prints the path the knight needs to take in order to visit all cells.
From the input you receive just the board size N (N > 4). On the output, print the board where each cell’s value is the number of the step which led to it,
e.g. cell (0, 0) will be 1, the first step, the next visited cell (0, 2) will have value 2, etc. In order to format the output,
 assume NxN < 1000 – no cell’s value will be more than 3 digits (you can pad the values with spaces with the string.PadLeft() method).
 */

package homeWork7;

import java.util.List;
import java.util.Scanner;

public class KnightTour {

	public static void findPath(int[][] matrix, int row, int col, int count) {

		// check if out of array
		if (row < 0 || col < 0 || row >= matrix.length
				|| col >= matrix[row].length) {
			return;
		}
		// check is free
		if (matrix[row][col] != 0) {
			return;
		}
		int currentCount = count;
		currentCount++;
		matrix[row][col] = currentCount;

		findPath(matrix, row + 1, col + 2, currentCount);
		findPath(matrix, row - 1, col + 2, currentCount);
		findPath(matrix, row - 1, col - 2, currentCount);
		findPath(matrix, row + 1, col - 2, currentCount);
		findPath(matrix, row - 2, col - 1, currentCount);
		findPath(matrix, row - 2, col + 1, currentCount);
		findPath(matrix, row + 2, col + 1, currentCount);
		findPath(matrix, row + 2, col - 1, currentCount);
		currentCount--;

	}

	public static void knightTour(int n) {
		int[][] board = new int[n][n];
		findPath(board, 0, 0, 0);
		for (int row = 0; row < board.length; row++) {
			System.out.println();
			for (int col = 0; col < board[0].length; col++) {
				System.out.print(board[row][col] + " ");
			}
		}

	}

	public static void main(String[] args) {
		System.out.println("Enter the size of board");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		knightTour(size);
		sc.close();

	}

}
