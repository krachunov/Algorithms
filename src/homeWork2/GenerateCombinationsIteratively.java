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

	static int[] arr;

	public static boolean itera(int n) {
		int index = arr.length - 1;
		while (index >= 0) {
			int tmp = arr[index];
			tmp++;
			arr[index] = tmp;
			if (arr[index] == n) {
				arr[index] = 1;
				index--;
			} else {
				break;
			}
		}
		if (index >= 0) {
			return true;
		}
		return false;
	}

	public static void print() {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void gen(int n) {
		boolean stropLoop = true;

		while (stropLoop) {
			stropLoop = itera(n);
			print();
		}
	}

	public static void main(String[] args) {
		int n = 3;
		arr = new int[n];
		gen(n);
	}
}
