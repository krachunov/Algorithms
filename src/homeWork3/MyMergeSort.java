package homeWork3;

import java.util.Arrays;

public class MyMergeSort {
	public static void mertgeSort(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();

		int start = 0;
		int end = arr.length;
		int mid = (start + end) / 2;
		int[] firstArr = new int[mid];
		int[] secondtArr = new int[end - mid];
		int[] sortedArr = new int[firstArr.length + secondtArr.length];

		if (arr.length > 1) {
			firstArr = Arrays.copyOfRange(arr, start, mid);
			secondtArr = Arrays.copyOfRange(arr, mid, end);
			mertgeSort(firstArr);
			mertgeSort(secondtArr);
		} else {
			int leftIndex = 0;
			int rigthIndex = 0;
			
			for (int i = 0; i < sortedArr.length; i++) {
				if (leftIndex < firstArr.length
						&& rigthIndex < secondtArr.length) {
					if (firstArr[leftIndex] <= secondtArr[rigthIndex]) {
						sortedArr[i] = firstArr[leftIndex];
						leftIndex++;
					} else {
						sortedArr[i] = secondtArr[rigthIndex];
						rigthIndex++;
					}
				} else if (leftIndex < firstArr.length&& rigthIndex > secondtArr.length) {
					sortedArr[i] = firstArr[leftIndex];
					leftIndex++;
				} else if (leftIndex > firstArr.length&& rigthIndex < secondtArr.length)  {
					sortedArr[i] = secondtArr[rigthIndex];
					rigthIndex++;
				}else{
					return;
				}
			}
			return;
		}
	}

	public static void main(String[] args) {
		int[] f = { 38, 27, 43, 3, 9, 82, 10 };
//		int[] a = new int[f.length];
		mertgeSort(f);
	}
}
