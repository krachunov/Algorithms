package homeWork5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DistanceBetweenVertices {
	private List<Node> allNodes;

	public DistanceBetweenVertices() {
		allNodes = new ArrayList<Node>();
	}

	public List<Node> getAllNodes() {
		return allNodes;
	}

	public void setAllNodes(List<Node> allNodes) {
		this.allNodes = allNodes;
	}

	public void addNode() {

	}

	public static void main(String[] args) {
		DistanceBetweenVertices graph = new DistanceBetweenVertices();

	}
}
