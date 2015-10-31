/**
 * Problem 3. Most Reliable Path
We have a set of towns and some of them are connected by direct paths.
Each path has a coefficient of reliability (in percentage): the chance to pass without incidents.
Your goal is to compute the most reliable path between two given nodes.
Assume all percentages will be integer numbers and round the result to the second digit after the decimal separator. 
For example, let’s consider the graph below:

 */
package homeWork6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MostReliablePath {

	public static void main(String[] args) {
		List<Edge> edges = new ArrayList<>();
		edges.add(new Edge(0, 3, 85));
		edges.add(new Edge(0, 4, 88));
		edges.add(new Edge(3, 1, 95));
		edges.add(new Edge(3, 5, 98));
		edges.add(new Edge(4, 5, 99));
		edges.add(new Edge(4, 2, 14));
		edges.add(new Edge(5, 1, 5));
		edges.add(new Edge(5, 6, 90));
		edges.add(new Edge(1, 6, 100));
		edges.add(new Edge(2, 6, 95));

		List<Edge> edges2 = new ArrayList<>();
		edges2.add(new Edge(0, 1, 94));
		edges2.add(new Edge(0, 2, 97));
		edges2.add(new Edge(2, 3, 99));
		edges2.add(new Edge(1, 3, 98));

		List<Edge> minimumSpaningForest = reliablePath(edges);
		for (Edge edge : minimumSpaningForest) {
			System.out.println(edge);
		}

	}

	static List<Edge> reliablePath(List<Edge> edges) {
		edges.sort(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				if (o1.getWightl() > o2.getWightl()) {
					return 1;
				} else if (o1.getWightl() < o2.getWightl()) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		int[] parent = new int[edges.size()];
		for (int i = 0; i < edges.size(); i++) {
			parent[i] = i;
		}
		List<Edge> spaningTree = new ArrayList<Edge>();
		for (Edge edge : edges) {
			int rootStartNode = findRoot(edge.getStartNode(), parent);
			int rootEndNode = findRoot(edge.getEndNode(), parent);
			if (rootStartNode != rootEndNode) {
				spaningTree.add(edge);
				parent[rootStartNode] = rootEndNode;
			}
		}

		return spaningTree;
	}

	private static int findRoot(int node, int[] parent) {
		int root = node;
		while (parent[root] != root) {
			root = parent[root];
		}

		while (node != root) {
			int oldParent = parent[node];
			parent[node] = root;
			node = oldParent;

		}
		return root;
	}
}
