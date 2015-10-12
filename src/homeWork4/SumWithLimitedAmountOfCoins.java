package homeWork4;

import java.util.Dictionary;
import java.util.Map;
import java.util.TreeMap;

public class SumWithLimitedAmountOfCoins {

	static TreeMap CalcPossibleSums(int[] nums, int targetSum) {

		TreeMap<Integer, Integer> possibleSums = new TreeMap();
		possibleSums.put(0, 0);

		for (int i = 0; i < nums.length; i++) {
			TreeMap<Integer, Integer> newSums = new TreeMap();

			for (Map.Entry<Integer, Integer> sum : possibleSums.entrySet()) {

				int newSum = sum.getKey() + nums[i];
				if (!possibleSums.containsKey(newSum)) {
					newSums.put(newSum, nums[i]);
				}
			}
			for (Map.Entry<Integer, Integer> sum1 : newSums.entrySet()) {
				possibleSums.put(sum1.getKey(), sum1.getValue());
			}
		}
		return possibleSums;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		
		TreeMap<Integer, Integer> a = CalcPossibleSums(arr, 5);
		for (Map.Entry<Integer, Integer> element : a.entrySet()) {
			System.out.println(element.getKey());
		}

	}
}
