package homeWrok1;

public class NestedLoops {
	static int c = 0;
	static int[] arr;
	static int index = 0;

	public static void nestetLoop(int index, int[] arr) {
		if (index < 0) {
			for (int i : arr) {
				System.out.println(i);
			}
		} else {
			for (int i = 0; i < index; i++) {
				arr[i]=i;
				nestetLoop(index-1,arr);
			}
		}
	}

	public static void main(String[] args) {
		int n = 3;
		arr = new int[n];
		nestetLoop(n, arr);
	}
}
