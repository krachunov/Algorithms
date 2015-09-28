/**
 *Problem 2.
 *Generate Permutations Iteratively
 *The above problem presented a recursive 
 *solution for generating all permutations
 *(without repeating elements) of a collection.
 *Your task is to write a non-recursive algorithm to achieve the same goal.
 *There shouldn’t be any recursive calls in your program (only loops). 
 *You may use the examples for problem 1 
 *to check whether your solution is correct.
 *
 */
package homeWork2;

import java.util.Scanner;

public class PermutationsWithoutRecursion {
	static int[] loops;
	static boolean[] used;
	static int totalPermutatin = 0;

	public static void permute(int i, int n) {

		while (n>0) {
			for (int j = 1; j < loops.length - 1; j++) {
				loops[i] = j;
				i++;
				if (i >= n) {
					printLoops(n);
					n--;
					i = 0;
				}
			}
		}
	}

	public static void printLoops(int n) {
		for (int i = 0; i < n; i++) {
			System.out.printf("%d ", loops[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("Enter the num of n");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		loops = new int[n];
		used = new boolean[n];
		permute(0, n);
		System.out.println("Totatl permutaions: " + totalPermutatin);
	}

}
