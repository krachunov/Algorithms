package homeWork5;

import java.util.ArrayList;
import java.util.List;

public class DistanceBetweenVertices {
	private List<List<Integer>> allNode;

	public DistanceBetweenVertices(int numberofNode) {
		setAllNode(new ArrayList<List<Integer>>());
		for (int i = 0; i <= numberofNode; i++) {
			getAllNode().add(new ArrayList<Integer>());
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

	public int distanceBetween(int start, int end) {
		int sum = 0;
		if (start == end) {
			return 1;
		}
		List<Integer> currentNode = getAllNode().get(start);
		for (Integer child : currentNode) {
			return sum+distanceBetween(child, end);
		}
		return sum;
	}

	public List<List<Integer>> getAllNode() {
		return allNode;
	}

	public void setAllNode(List<List<Integer>> allNode) {
		this.allNode = allNode;
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
		 int x = graph.distanceBetween(1, 6);
		 System.out.println(x);
	}
}
