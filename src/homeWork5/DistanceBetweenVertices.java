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

	public void addChild(int parent, int child) {
		if (parent > getAllNode().size()) {
			System.err.println("There is no such node");
		}
		getAllNode().get(parent).add(child);
	}

	public int distanceBetween(int start, int end) {
		if (start == end) {
			return 1;
		} else {
			List<Integer> currentList = getAllNode().get(start);
			for (Integer integer : currentList) {
				distanceBetween(start, integer);
			}

		}
		return -1;
	}

	public List<List<Integer>> getAllNode() {
		return allNode;
	}

	public void setAllNode(List<List<Integer>> allNode) {
		this.allNode = allNode;
	}

	public static void main(String[] args) {
		DistanceBetweenVertices graph = new DistanceBetweenVertices(2);
		graph.addChild(1, 2);
		int x = graph.distanceBetween(1, 2);
		System.out.println(x);
	}
}
