/**
 * Problem 1. Fractional Knapsack Problem
A modification of the famous knapsack problem is the so-called continuous (or fractional) knapsack problem. 
We have N items, each with a certain weight and price. The knapsack has a maximum capacity, so we need to choose what to take in order to maximize the value (price) of the items in it. 
Unlike the classical version of the problem where an object should either be taken in its entirety or not at all,
 in this version we can take a fraction of each item. For example, such items may be liquids or powders; unlike solid objects which (presumably) we cannot split, 
 we�ll assume that all items under consideration can be divided in any proportion. 
 Therefore, the weight can be though as the maximum quantity Q of an item we are allowed to take � we can take any amount in the range [0 � Q].
  Note that in this version of the problem the knapsack will always be filled completely (if the total quantity of items is greater than its capacity).
Items will be given on separate lines in format price -> weight. Round all numbers to two digits after the decimal separator. Examples:
 */
package homeWork7;

import homeWork6.Edge;

public class FractionalKnapsack {
	static class Item implements Comparable<Item> {
		private int weight;
		private int price;
		private double ratio = price / weight;

		@Override
		public int compareTo(Item other) {

			return this.ratio > other.ratio ? 1 : this.ratio < other.ratio ? -1
					: 0;
		}
	}

	public static void main(String[] args) {
		
	}

}
