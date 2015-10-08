/**
 * Problem 2.	Implement Interpolation Search
In the SortableCollection class there is an empty method InterpolationSearch. Your task is to implement it. 
Write unit tests in the InterpolationSearchTests class (you may use the already implemented BinarySearch unit tests as a template).

 */

package homeWork3;

public class InterpolationSearch {

	public static int search(int[] arr, int searchingElement) {
		int low = 0;
		int high = arr.length - 1;
		int mid = -1;

		while (arr[low] <= searchingElement && arr[high] >= searchingElement) {
			mid = low + ((searchingElement - arr[low]) * (high - low))
					/ (arr[high] - arr[low]);
			if (arr[mid] < searchingElement) {
				low = mid + 1;
			} else if (arr[mid] > searchingElement) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		if (arr[low] == searchingElement) {
			return low;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 4, 5, 6, 10, 14, 20, 44 };
		System.out.println(search(a, 10));
	}

}
