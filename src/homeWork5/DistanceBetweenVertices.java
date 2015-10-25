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
				distanceBetweenRecursive(counter + 1, child, end);
				getViewNode().set(child, false);
			}

		}
		return;
	}

	public void distanceBetweenRecursive(int start, int end) {
		setCount(0);
//		getViewNode().clear();
		distanceBetweenRecursive(getCount(), start, end);
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

		graph.distanceBetweenRecursive(1, 6);
		System.out.println("--------------------");
		graph.distanceBetweenRecursive(1, 5);
		System.out.println("--------------------");
		graph.distanceBetweenRecursive(5, 6);
		System.out.println("--------------------");
		graph.distanceBetweenRecursive(5, 8);

	}
}
