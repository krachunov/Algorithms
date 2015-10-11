/**
 * Problem 5.	Implement the Fisher-Yates Shuffle
Implement the Fisher-Yates shuffle algorithm. Use the Shuffle method in the SortableCollection class. 
In the main program, write several test cases and shuffle arrays of different sizes repeatedly to show that shuffling is done properly (e.g. no clustering occurs).

 */
package homeWork3;

import java.util.Random;

public class FisherYatesShuffle<T> {

	public static int[] shuffle(int[] arrToSort) {
		int[] arr = arrToSort;
		Random rnd = new Random();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int r = rnd.nextInt(n - 1);
			int temp = arr[i];
			arr[i] = arr[r];
			arr[r] = temp;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] f = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] shuffled = shuffle(f);
		for (Integer i : shuffled) {
			System.out.print(i + " ");
		}
	}
}
