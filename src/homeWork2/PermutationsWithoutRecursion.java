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

	public static void permute(int n) {

		int index = loops.length-1 ;
		int count = 1;
			while (true) {
				for (int i = 1; i <= n; i++) {
				loops[index] = i;
				printLoops(n);
				if(i>=n){
					int tmp = loops[index-1];
					loops[index-1]=++tmp;
					break;
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
		permute(n);
		// System.out.println("Totatl permutaions: " + totalPermutatin);
	}

}
