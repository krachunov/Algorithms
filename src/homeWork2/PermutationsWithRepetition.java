package homeWork2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PermutationsWithRepetition {

	public static void permutationsRep(int[] ps) {
		Arrays.sort(ps);
		permute(ps, 0, ps.length);

	}

	public static void permute(int[] ps, int start, int n) {
		print(ps);
		int tmp = 0;

		if (start < n) {
			for (int i = n - 2; i >= start; i--) {
				for (int j = i + 1; j < n; j++) {
					if (ps[i] != ps[j]) {

						// swap ps[i] <--> ps[j]
						tmp = ps[i];
						ps[i] = ps[j];
						ps[j] = tmp;

						permute(ps, i + 1, n);
					}
				}

				// Undo all modifications done by
				// recursive calls and swapping
				tmp = ps[i];
				for (int k = i; k < n - 1;)
					ps[k] = ps[++k];
				ps[n - 1] = tmp;
			}
		}
	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = { 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
		permutationsRep(a);
		
	}

}
