package homeWork3;

import java.util.Scanner;

public class pi {
	public static void main(String[] args) {
		// Create a Scanner object
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter input
		System.out.println("Enter number of terms");
		double SomeNumber = input.nextDouble(); // value of i user entered
		double sum = 0;
		for (double i = 0; i < 10000; i++) {
			if (i % 2 == 0) {
				double a = (-1) / (2 * i - 1);
				sum = sum + a;
			}

			else {
				double b = 1 / (2 * i - 1);
				sum = sum + b;
			}
		}

		System.out.println(sum);

	}
}
