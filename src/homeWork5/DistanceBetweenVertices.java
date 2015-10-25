/**
 * Problem 1.	Distance between Vertices
We are given a directed graph consisting of N vertices and M edges.
We are given also a set of pairs of vertices. Find the shortest distance between each pair of vertices or -1 if there is no path connecting them.
There are no specified requirements for the input and output, so you may hardcode the input and output values.

 */

package homeWork5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DistanceBetweenVertices {
	private List<List<Integer>> allNode;
	private List<Boolean> viewNode;
	int count = 0;

	public DistanceBetweenVertices(int numberofNode) {
		setAllNode(new ArrayList<List<Integer>>());
		setViewNode(new ArrayList<Boolean>());
		for (int i = 0; i <= numberofNode; i++) {
			getAllNode().add(new ArrayList<Integer>());
			getViewNode().add(false);
		}
	}

	public void addChild(int parent, int... childs) {
		if (parent > getAllNode().size()) {
			System.err.println("There is no such node");
		}
		if (childs.length > 0) {
			for (int child : childs) {
				getAllNode().get(parent).add(child);
			}
		}
	}

	// recursive method
	private void distanceBetweenRecursive(int counter, int start, int end) {
		getViewNode().set(start, true);
		if (start == end) {
			System.out.println(counter);
			return;
		}
		List<Integer> currentNode = getAllNode().get(start);
		for (Integer child : currentNode) {
			if (getViewNode().get(child) != true) {
				distanceBetweenRecursive(getCount() + 1, child, end);
				getViewNode().set(child, false);
			}

		}
		return;
	}

	public void distanceBetweenRecursive(int start, int end) {
		distanceBetweenRecursive(getCount(), start, end);
	}

	/*
	 * private int distanceBetweenRecursive(int counter, int start, int end) {
	 * int tempCount = counter;
	 * 
	 * if (start == end) { return getCount(); } getViewNode().set(start, true);
	 * 
	 * List<Integer> currentNode = getAllNode().get(start); if
	 * (currentNode.size() > 0) { for (Integer child : currentNode) { if
	 * (getViewNode().get(child) != true) { tempCount++; int x =
	 * distanceBetweenRecursive(tempCount, child, end); if (x == end) {
	 * 
	 * return getCount(); } } else { continue; } } return getCount(); }
	 * tempCount = getCount(); tempCount--; setCount(tempCount);
	 * getViewNode().set(start, false); return -1; }
	 */
	// Iterative method
	public int distanceBetween(int start, int end) {
		int sum = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		int currentNode = -1;

		do {
			currentNode = queue.poll();
			if (currentNode == end) {
				return sum;
			}

			getViewNode().set(currentNode, true);
			List<Integer> currentNodeChildList = getAllNode().get(currentNode);

			if (currentNodeChildList.size() > 0) {
				sum++;
				for (Integer child : currentNodeChildList) {
					if (getViewNode().get(child) != true) {
						queue.offer(child);

					}
				}
			}

		} while (queue.size() > 0);

		return -1;

	}

	public List<List<Integer>> getAllNode() {
		return allNode;
	}

	public void setAllNode(List<List<Integer>> allNode) {
		this.allNode = allNode;
	}

	public List<Boolean> getViewNode() {
		return viewNode;
	}

	public void setViewNode(List<Boolean> viewNode) {
		this.viewNode = viewNode;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public static void main(String[] args) {
		DistanceBetweenVertices graph = new DistanceBetweenVertices(8);
		graph.addChild(1, 4);
		graph.addChild(2, 4);
		graph.addChild(3, 4, 5);
		graph.addChild(4, 6);
		graph.addChild(5, 3, 7, 8);
		graph.addChild(6);
		graph.addChild(7, 8);
		graph.addChild(8);
		System.out.println();

		graph.distanceBetweenRecursive(3, 7);

	}
}
