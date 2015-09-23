/**
 * Problem 4.	Combinations without Repetition
Modify the previous program to skip duplicates, e.g. (1 1) is not valid.

 */
package homeWrok1;

public class CombinationsWithOutRepetition {
	static int c = 0;
	static int[] loops;
	static int numberOfIterations = 3;
	static int numberOfLoops = 2;
	static int count2;

	public static void nestedLoops(int currentLoop, int count2) {
		if (currentLoop == numberOfLoops) {
			printLoops();
			return;
		}
		for (int counter = 1; counter <= numberOfIterations; counter++) {
			loops[currentLoop] = counter;
			nestedLoops(currentLoop + 1, counter);
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
		nestedLoops(0, 0);
	}
}
