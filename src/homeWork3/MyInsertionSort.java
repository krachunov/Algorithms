package homeWork3;

public class MyInsertionSort {
	public static void swap(int x, int y) {
		int tmp = x;
		x = y;
		y = tmp;
	}

	public static int[] sorting(int[] arr) {
		int sortedIndex = 0;
		int currentIndex = 1;
		while (sortedIndex < arr.length) {
			for (int i = currentIndex; i < arr.length; i++) {
				for (int j = currentIndex; j < 0; j--) {
					if(arr[i]<arr[j]){
						
					}
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 4, 5, 6, 7, 1, 2, 2 };

		sorting(a);

		for (int i : a) {
			System.out.println(i);
		}

	}
}
