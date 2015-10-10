package homeWork3;

import java.util.List;

public class MyHeapTest {

	public static void main(String[] args) {
		MyHeapsSort<Integer> a = new MyHeapsSort<Integer>();
		Integer[] f = { 2, 3, 4, 1, 5, 1, 1, 5 };
		List<Integer>sortedList = a.heapSort(f);
		
		for (Integer element : sortedList) {
			System.out.print(element+" ");
		}
	}
}
