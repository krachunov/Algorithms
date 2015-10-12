package homeWork4;

public class SumWithUnlimitedAmountOfCoins {

	public static boolean[] calc(int[] nums, int targerSum) {
		boolean[] possible = new boolean[targerSum + 1];
		possible[0] = true;
		for (int sum = 0; sum < possible.length; sum++)
			if (possible[sum])
				for (int i = 0; i < nums.length; i++) {
					int newSum = sum + nums[i];
					if (newSum <= targerSum)
						possible[newSum] = true;
				}
		return possible;
	}

	public static void main(String[] args) {
		int[]arr = {1,2,3};
		boolean[] a = calc(arr, 5);
		for (boolean b : a) {
			System.out.println(b);
		}
	}
}
