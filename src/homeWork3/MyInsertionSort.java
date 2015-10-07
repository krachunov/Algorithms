/**
 * Problem 1.	Implement Insertion Sort
Insertion sort is very simple: iterate the elements and move them to the left so that they end up with a smaller (or equal) element to the left and a larger one to the right. Check out Visualgo for a visual representation.
Since all classes implementing the ISorter interface in the skeleton work with a List<T>, we can use the very convenient RemoveAt and Insert methods to implement this sorting algorithm in just a few lines of code.
We can start at index 1 and check to the left until we find an element which is at least equal to the current element or until we reach index 0. Keeping track of where the last larger element was found, we can remove the element and insert it there:

 */

package homeWork3;

public class MyInsertionSort {
	public static void swap(int x, int y) {
		int tmp = x;
		x = y;
		y = tmp;
	}

	public static void sorting(int[] arr) {
		int sortedIndex = 0;
		int currentIndex = -1;
		while (sortedIndex < arr.length) {

			for (int i = 1; i < arr.length; i++) {
				currentIndex = i;

				for (int j = currentIndex; j >= 0; j--) {
					if (i == j) {
						continue;
					} else {
						if (arr[i] > arr[j]) {
							continue;
						} else {
							int temp = arr[i];
							arr[i] = arr[j];
							arr[j] = temp;
						}
					}
				}
			}
			sortedIndex++;
		}
		for (int z : arr) {
			System.out.println(z);
		}
	}

	public static void main(String[] args) {
		int[] a = { 5, 4, 3, 2, 1 };
		int[] b = { 1, 2, 3, 4, 5 };
		int[] c = { 2, 3, 4, 5, 1 };
		int[] d = { 2, 3, 4, 5, 1, 6 };
		int[] e = { 2, 3, 4, 1, 5 };
		int[] f = { 2, 3, 4, 1, 5, 1, 1, 5 };

		sorting(f);

	}
}
