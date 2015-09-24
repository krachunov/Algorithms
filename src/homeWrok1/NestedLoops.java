package homeWrok1;

public class NestedLoops {

	static int[] loops;
	static int n = 10;

	public static void nestedLoops(int currentLoop) {
		if (currentLoop == n) {
			printLoops();
			return;
		}
		for (int i = 1; i <= n; i++) {
			loops[currentLoop] = i;
			nestedLoops(currentLoop + 1);
		}
	}

	public static void printLoops() {
		for (int i = 0; i < n; i++) {
			System.out.printf("%d ", loops[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {

		loops = new int[n];
		nestedLoops(0);
	}
}
