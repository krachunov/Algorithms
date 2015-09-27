/**
 *Problem 3.	Generate Combinations Iteratively
 *Write an iterative program to generate all combinations 
 *(without repetition) of k elements from a set of n elements.
 *Remember, in combinations, the order of elements doesn’t matter 
 *– (1 2) and (2 1) are considered the same combination. 
 *You are not allowed to use recursion.
 * Search the Internet for a suitable algorithm.
 *
 */
package homeWork2;

import java.util.Scanner;

public class GenerateCombinationsIteratively {
	static int c = 0;
	static int[] loops;
	static int numberOfLoops = 2;
	static int totalCombinations = 0;

	/**
	 * 
	 * @param index
	 *            - index of array
	 * @param start
	 *            - start count
	 * @param n
	 *            - number of iteration
	 * @param k
	 *            - number of nested loop
	 */
	public static void nestedLoops(int index, int start, int n, int k) {
		if (index == loops.length) {
			printLoops();
			totalCombinations++;
			return;
		}
		for (int i = start; i <= n; i++) {
			loops[index] = i;
			nestedLoops(index + 1, i + 1, n, k - 1);
		}
	}

	public static void printLoops() {
		for (int i = 0; i < loops.length; i++) {
			System.out.printf("%d ", loops[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number n");
		int n = sc.nextInt();
		System.out.println("Enter the number k");
		int k = sc.nextInt();
		loops = new int[k];
		nestedLoops(0, 1, n, k);
		System.out.println("Totatl tombinations: " + totalCombinations);
	}
}
