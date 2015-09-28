/**
 * Problem 1.	Permutations
 *Write a recursive program for 
 *generating and printing all permutations 
 *(without repetition) of the numbers 1, 2, ..., n
 * for a given integer number n (n > 0). The 
 * number of permutations is found by calculating n!
 */
package homeWork2;

import java.util.Scanner;

public class Permutations {
	static int[] loops;
	static boolean[] used;
	static int totalPermutatin = 0;

	public static void permute(int i, int n) {
		if (i > n) {
			printLoops(n);
			totalPermutatin++;

		} else {
			for (int k = 0; k < n; k++) {

				if (!used[k]) {
					used[k] = true;
					loops[k] = i;

					permute(i + 1, n);

					used[k] = false;
				}
			}
		}
	}

	public static void permute(int n) {
		permute(1, n);
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
		permute(n);
		System.out.println("Totatl permutaions: " + totalPermutatin);
	}

}
