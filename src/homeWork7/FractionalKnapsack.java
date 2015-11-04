/**
 * Problem 1. Fractional Knapsack Problem
A modification of the famous knapsack problem is the so-called continuous (or fractional) knapsack problem. 
We have N items, each with a certain weight and price. The knapsack has a maximum capacity, so we need to choose what to take in order to maximize the value (price) of the items in it. 
Unlike the classical version of the problem where an object should either be taken in its entirety or not at all,
 in this version we can take a fraction of each item. For example, such items may be liquids or powders; unlike solid objects which (presumably) we cannot split, 
 we’ll assume that all items under consideration can be divided in any proportion. 
 Therefore, the weight can be though as the maximum quantity Q of an item we are allowed to take – we can take any amount in the range [0 … Q].
  Note that in this version of the problem the knapsack will always be filled completely (if the total quantity of items is greater than its capacity).
Items will be given on separate lines in format price -> weight. Round all numbers to two digits after the decimal separator. Examples:
 */
package homeWork7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import homeWork6.Edge;

public class FractionalKnapsack {
	static class Item {
		private double weight;
		private double price;
		private double ratio;

		public Item(double weight, double price) {
			this.weight = weight;
			this.price = price;
			// double x =
			this.ratio = price / weight;
		}

		public double getPrice() {
			return price;
		}

		public double getWeight() {
			return weight;
		}

	}

	public static void knapsack(List<Item> items, int capacity) {
		double totalPrice = 0;
		List<Item> knapsack = new ArrayList<>();
		int currentCapacity = capacity;
		items.sort(new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return o1.ratio > o2.ratio ? 1 : o1.ratio < o2.ratio ? -1 : 0;
			}
		});

		for (Item item : items) {
			if (item.getPrice() <= currentCapacity) {
				knapsack.add(item);
				currentCapacity -= item.getPrice();
				continue;
			} else if (currentCapacity > 0) {
				double currentRatio = currentCapacity / item.getPrice();
				double partOfPrice = (item.getPrice() * currentRatio);
				double partOfWeight = item.getWeight() * currentRatio;

				Item partOfItem = new Item(partOfWeight, partOfPrice);
				knapsack.add(partOfItem);
				currentCapacity -= partOfPrice;
				continue;
			} else {
				// break;
			}
		}
		for (Item item : knapsack) {
			totalPrice += item.getWeight();
		}
		System.out.println(totalPrice);
	}

	public static void main(String[] args) {
		List<Item> item = new ArrayList<Item>();
		item.add(new Item(12, 8));
		item.add(new Item(16, 8));
		item.add(new Item(25, 10));

		List<Item> item2 = new ArrayList<Item>();
		item2.add(new Item(13, 7));
		item2.add(new Item(15, 7));

		List<Item> item3 = new ArrayList<Item>();
		item3.add(new Item(12, 14));
		item3.add(new Item(45, 54));
		item3.add(new Item(98, 78));
		item3.add(new Item(21, 51));
		item3.add(new Item(64, 11));
		item3.add(new Item(90, 117));
		item3.add(new Item(33, 17));
		item3.add(new Item(64, 23));
		item3.add(new Item(7, 3));
		
		
		knapsack(item3, 134);
	}
}
