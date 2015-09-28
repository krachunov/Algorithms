package homeWork2;

/**
 *Problem 4.	Generate Subsets of String Array
 *Write a recursive program for generating and 
 *printing all subsets of k strings from given set of strings s.
 *
 */

import java.util.Scanner;

public class CombinationsWithOutRepetition {
	static int c = 0;
	static String[] loops;
	static String[] stringElement;
	static int numberOfLoops = 2;
	static int totalPermutatin = 0;

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
			totalPermutatin++;
			return;
		}
		for (int i = start; i <= n; i++) {
			if (i == n) {
				break;
			}
			loops[index] = stringElement[i];
			nestedLoops(index + 1, i + 1, n, k - 1);
		}
	}

	public static void printLoops() {
		for (int i = 0; i < loops.length; i++) {
			System.out.printf("%s ", loops[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number element");
		String element = sc.nextLine();
		stringElement = element.split(" ");

		System.out.println("Enter the number k");
		int k = sc.nextInt();
		loops = new String[k];
		nestedLoops(0, 0, stringElement.length, k);
		System.out.println("Totatl permutaions: " + totalPermutatin);
	}
}
