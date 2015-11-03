package classWork7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Greedy {
	public static void main(String[] args) {
		
//		Object[] a = new[]{
//				new {Start=1,end=1}
//		};
		
		List<Integer> availableCoins = new ArrayList<Integer>();
		availableCoins.addAll(Arrays.asList(1, 2, 5, 10, 20, 50));
		int targetSum = 923;

		Map<Integer, Integer> selectedCoin = chooseCoins(availableCoins,
				targetSum);

		for (java.util.Map.Entry<Integer, Integer> integer : selectedCoin
				.entrySet()) {
			System.out.println("Coins " + integer.getKey() + "_- > "
					+ integer.getValue());
		}
	}

	private static Map<Integer, Integer> chooseCoins(
			List<Integer> availableCoins, int targetSum) {
		Map<Integer, Integer> result = new TreeMap<Integer, Integer>();
		int sum = 0;
		availableCoins.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 > o2 ? -1 : o1 < o2 ? 1 : 0;
			}
		});
		int index = 0;
		while (sum < targetSum) {
			if (sum + availableCoins.get(index) <= targetSum) {
				sum += availableCoins.get(index);
				if (!result.containsKey(availableCoins.get(index))) {
					result.put(availableCoins.get(index), 1);
				} else {
					int temCounter = result.get(availableCoins.get(index));
					result.put(availableCoins.get(index), ++temCounter);
				}

			} else {
				index++;
			}

		}

		return result;
	}
}
