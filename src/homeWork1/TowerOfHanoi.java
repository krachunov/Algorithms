/**
 * Your task is to solve the famous Tower of Hanoi puzzle using recursion. 
In this problem, you have three rods (let�s call them source, destination and spare). Initially, there are n disks, all placed on the source rod like in the picture below:
 
Your objective is to move all disks from the source rod to the destination rod. There are several rules:
1)	Only one disk can be moved at a time
2)	Only the topmost disk on a rod can be moved
3)	A disk can only be placed on top of a larger disk or on an empty rod

 */

package homeWork1;

import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoi {
	static int numberOfSteps = 0;
	static Stack<Integer> sorce = new Stack<Integer>();
	static Stack<Integer> spare = new Stack<Integer>();
	static Stack<Integer> destination = new Stack<Integer>();

	static void printRods(int bottomDisk) {
		System.out.printf("In step #%d, move disk %d   \n", numberOfSteps,
				bottomDisk);
		System.out.println("Sorce: " + sorce.toString());
		System.out.println("spare: " + spare.toString());
		System.out.println("Destination: " + destination.toString());
	}

	static void hanoi(int bottomDisk, Stack<Integer> sorce,
			Stack<Integer> spare, Stack<Integer> destination) {
		if (bottomDisk > 0) {
			hanoi(bottomDisk - 1, sorce, destination, spare);
			destination.push(sorce.pop());

			numberOfSteps++;
			printRods(bottomDisk);
			hanoi(bottomDisk - 1, spare, sorce, destination);

		}
	}

	static void crateDisks(int n) {
		for (int i = n; i > 0; i--) {
			sorce.push(i);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of disks");
		int numberOfDisk = sc.nextInt();
		crateDisks(numberOfDisk);

		hanoi(numberOfDisk, sorce, spare, destination);
		System.out.println(numberOfSteps);

	}
}
