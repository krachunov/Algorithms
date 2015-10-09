/**
 * Problem 3.	Combinations with Repetition
Write a recursive program for generating and printing all combinations with duplicates of k elements from a set of n elements (k <= n). In combinations, the order of elements doesn’t matter, therefore (1 2) and (2 1) are the same combination, meaning that once you print/obtain (1 2), (2 1) is no longer valid.

 */
package homeWork1;

public class CombinationsWithRepetition {
	static int c = 0;
	static int[] loops;
	static int numberOfIterations = 3;
	static int numberOfLoops = 3;

	public static void nestedLoops(int currentLoop) {
		if (currentLoop == numberOfLoops) {
			printLoops();
			return;
		}
		for (int counter = 1; counter <= numberOfIterations; counter++) {
			loops[currentLoop] = counter;
			nestedLoops(currentLoop + 1);
		}
	}

	public static void printLoops() {
		for (int i = 0; i < numberOfLoops; i++) {
			System.out.printf("%d ", loops[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {

		loops = new int[numberOfLoops];
		nestedLoops(0);
	}
}
