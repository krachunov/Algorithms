/**
 * Problem 4.	Combinations without Repetition
Modify the previous program to skip duplicates, e.g. (1 1) is not valid.

 */
package homeWrok1;

public class CombinationsWithOutRepetition {
	static int c = 0;
	static int[] loops;
	static int numberOfLoops = 2;

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
			return;
		}
		for (int i = start; i <= n; i++) {
			loops[index] = i;
			nestedLoops(index + 1, i+1, n, k - 1);
		}
	}

	public static void printLoops() {
		for (int i = 0; i < loops.length; i++) {
			System.out.printf("%d ", loops[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int n = 5;
		int k = 3;
		loops = new int[k];
		nestedLoops(0, 1, n, k);
	}
}
