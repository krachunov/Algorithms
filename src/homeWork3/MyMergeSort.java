package homeWork3;

import java.util.Arrays;

public class MyMergeSort {
	public static void mertgeSort(int[] arr, int start, int end) {

		if (arr.length > 1) {
			int mid = (start + end) / 2;
			mertgeSort(Arrays.copyOfRange(arr, start, mid), start, mid);
			mertgeSort(Arrays.copyOfRange(arr, mid + 1, end), mid + 1, end);
		} else {
			return;
		}
	}

	public static void main(String[] args) {
		int[] f = { 2, 3, 4, 1, 5, 1, 1, 5 };
		mertgeSort(f, 0, f.length);
	}

}
