package homeWrok1;

import java.util.Stack;

public class TowerOfHanoi {

	static void hanoi(int bottomDisk, Stack sorce, Stack spare,
			Stack destination) {
		if (bottomDisk > 0) {
			hanoi(bottomDisk - 1, sorce, destination, spare);
			destination.push(sorce.pop());
			hanoi(bottomDisk - 1, spare, sorce, destination);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> sorce = new Stack<Integer>();
		sorce.push(6);
		sorce.push(5);
		sorce.push(4);
		sorce.push(3);
		sorce.push(2);
		sorce.push(1);
		int n = sorce.size();
		
		Stack<Integer> spare = new Stack<Integer>();
		Stack<Integer> destination = new Stack<Integer>();

		hanoi(n, sorce, spare, destination);

	

	}
}
