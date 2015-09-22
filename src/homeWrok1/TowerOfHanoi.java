package homeWrok1;

import java.util.Stack;

public class TowerOfHanoi {
	static int numberOfSteps = 0;
	static Stack<Integer> sorce = new Stack<Integer>();
	static Stack<Integer> spare = new Stack<Integer>();
	static Stack<Integer> destination = new Stack<Integer>();

	static void printRods() {
		System.out.println("Sorce: " + sorce.toString());
		System.out.println("spare: " + spare.toString());
		System.out.println("Destination: " + destination.toString());
	}

	static void hanoi(int bottomDisk, Stack<Integer> sorce,
			Stack<Integer> spare, Stack<Integer> destination) {
		if (bottomDisk > 0) {
			hanoi(bottomDisk - 1, sorce, destination, spare);
			destination.push(sorce.pop());
			System.out.printf("In step %d, move disk %d form  \n",
					numberOfSteps, bottomDisk);
			printRods();
			numberOfSteps++;
			hanoi(bottomDisk - 1, spare, sorce, destination);
		}
	}

	public static void main(String[] args) {
		sorce.push(6);
		sorce.push(5);
		sorce.push(4);
		sorce.push(3);
		sorce.push(2);
		sorce.push(1);
		int n = sorce.size();

		hanoi(n, sorce, spare, destination);
		System.out.println(numberOfSteps);

	}
}
