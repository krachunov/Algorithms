package homeWrok1;

public class NestedLoops {

	public static void nestetLoop(int n, int end) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.println(i + " " + j);
			}
		}

	}

	public static void main(String[] args) {
		int n = 2;
		int[] i = new int[n];

		nestetLoop(n, n);

	}
}
