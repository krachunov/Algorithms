package homeWork3;

import java.util.Arrays;

public class MyMergeSort {
	public static int[] mertgeSort(int[] arr) {
		if (arr.length <= 1) {
			return arr;
		}

		int start = 0;
		int end = arr.length;
		int mid = (start + end) / 2;
		int[] firstArr = Arrays.copyOfRange(arr, start, mid);
		int[] secondtArr = Arrays.copyOfRange(arr, mid, end);

		firstArr = mertgeSort(firstArr);
		secondtArr = mertgeSort(secondtArr);
		return merge(firstArr, secondtArr);

	}

	private static int[] merge(int[] firstArr, int[] secondtArr) {
		int[] mergArr = new int[firstArr.length + secondtArr.length];
		int leftIndex = 0;
		int rightIndex = 0;
		int mergedIndex = 0;
		while (leftIndex < firstArr.length && rightIndex < secondtArr.length) {
			if (firstArr[leftIndex] < secondtArr[rightIndex]) {
				mergArr[mergedIndex] = firstArr[leftIndex];
				mergedIndex++;
				leftIndex++;
			} else {
				mergArr[mergedIndex] = secondtArr[rightIndex];
				mergedIndex++;
				rightIndex++;
			}
		}
		while (leftIndex < firstArr.length) {
			mergArr[mergedIndex] = firstArr[leftIndex];
			mergedIndex++;
			leftIndex++;
		}
		while (rightIndex < secondtArr.length) {
			mergArr[mergedIndex] = secondtArr[rightIndex];
			mergedIndex++;
			rightIndex++;
		}
		return mergArr;
	}

	public static void main(String[] args) {
		int[] f = { 38, 27, 43, 3, 9, 82, 10 };
		
		int[] a = mertgeSort(f);

		for (int i : a) {
			System.out.print(i + " ");
		}
	}
}
