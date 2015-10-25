/**
 * Problem 3 Cycles in a Graph
Write a program to check whether an undirected graph is acyclic or holds any cycles.
 */

package homeWork5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CyclesInGraph {
	private List<List<Integer>> allNode;
	private Set<Integer> everySingleNode;
	private List<Boolean> viewNode;
	int count = 0;

	public CyclesInGraph(int numberofNode) {
		setAllNode(new ArrayList<List<Integer>>());
		setViewNode(new ArrayList<Boolean>());
		setEverySingleNode(new HashSet<Integer>());
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
				if (!getEverySingleNode().contains(childs)) {
					getEverySingleNode().add(child);
				}
			}
		}
	}

	// recursive method
	private void DFS(int start) {
		if (getViewNode().get(start) == true) {
			System.out.println("Acyclic: No");
			return;
		}
		getViewNode().set(start, true);
		List<Integer> currentNode = getAllNode().get(start);
		for (Integer child : currentNode) {
			if (getViewNode().get(child) != true) {
				DFS(child);
				// getViewNode().set(child, false);
			}

		}
		return;
	}

	public void checkIsCycles() {
		for (Integer node : getEverySingleNode()) {
			if (getViewNode().get(node) != true) {
				DFS(node);
			}
		}
	}

	public List<List<Integer>> getAllNode() {
		return allNode;
	}

	public void setAllNode(List<List<Integer>> allNode) {
		this.allNode = allNode;
	}

	public Set<Integer> getEverySingleNode() {
		return everySingleNode;
	}

	public void setEverySingleNode(Set<Integer> everySingleNode) {
		this.everySingleNode = everySingleNode;
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
		CyclesInGraph graph = new CyclesInGraph(8);
		graph.addChild(1, 4);
		graph.addChild(4, 1);
		graph.addChild(3, 4, 5);
		graph.addChild(4, 6);
		graph.addChild(5, 3, 7, 8);
		graph.addChild(6);
		graph.addChild(7, 8);
		graph.addChild(8);
		System.out.println();

		graph.checkIsCycles();

	}
}
