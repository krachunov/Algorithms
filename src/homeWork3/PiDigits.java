package homeWork3;

public class PiDigits {

	public static void main(String[] args) {
		
		double pi = 0;
		double iterations = 1000000;
		double i;
		for (i = 1; i < iterations; i += 4) {
			pi += 4 / i - 4 / (i + 2);
		}
		System.out.printf("%.1000f", pi);

	}
}