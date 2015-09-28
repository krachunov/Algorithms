/**
 * Problem 6.	*Snakes
 *You can test your solution to the problem in the Judge system here.
 *A snake is a sequence of several square blocks, attached one after another. 
 *A snake starts with a block at some position and continues with another block to the left, right, up or down,
 *then again with another block to the left, right, up or down, etc. A snake of size N consists of a sequence of N blocks and is not allowed to cross itself.
 *You are given a number N and you should find all possible snakes of N blocks, 
 *represented as sequences of moves denoted as: S (start), L (move left), R (move right), U (move up) and D (move down). Examples (for N = 1, 2, 3, 4, and 5):
 *
 */
package homeWork2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snake {
	// static List<Character> dir = new ArrayList<Character>();
	static int snakeLength;

	static void printDir(List<Character> dir) {
		System.out.println();
		for (Character character : dir) {
			System.out.print(character);
		}
	}

	public static void findPath(char[][] matrix, int x, int y, char symbol,
			List<Character> dir) {
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
		if (snakeLength > 0) {
			// System.out.print(symbol);
			matrix[row][col] = 'x';
			dir.add(symbol);
			snakeLength--;
			findPath(matrix, x, y + 1, 'R', dir);
			findPath(matrix, x + 1, y, 'D', dir);
			findPath(matrix, x, y - 1, 'L', dir);
			findPath(matrix, x - 1, y, 'U', dir);

			matrix[row][col] = ' ';
			dir.remove(dir.size() - 1);
			snakeLength++;
		} else {
			printDir(dir);
			
			return;
		}

	}

	public static void main(String[] args) {
		System.out.println("Enter the snake length");
		Scanner sc = new Scanner(System.in);
		snakeLength = sc.nextInt();
		List<Character> dir = new ArrayList<Character>();
		char[][] matrix = { { ' ', ' ', ' ', ' ', ' ', ' ' },
				{ ' ', ' ', ' ', ' ', ' ', ' ' },
				{ ' ', ' ', ' ', ' ', ' ', ' ' },
				{ ' ', ' ', ' ', ' ', ' ', ' ' },
				{ ' ', ' ', ' ', ' ', ' ', ' ' },
				{ ' ', ' ', ' ', ' ', ' ', ' ' } };
		findPath(matrix, 0, 0, 's', dir);
	}
}
