package homeWork6;

import homeWork1.Area;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
	static int n = 9;

	public static void main(String[] args) {
		List<Edge> edges = new ArrayList<>();
		edges.add(new Edge(0, 3, 9));
		edges.add(new Edge(0, 5, 4));
		edges.add(new Edge(0, 8, 5));
		edges.add(new Edge(1, 4, 8));
		edges.add(new Edge(1, 7, 7));
		edges.add(new Edge(2, 6, 12));
		edges.add(new Edge(3, 5, 2));
		edges.add(new Edge(3, 6, 8));
		edges.add(new Edge(4, 8, 20));
		edges.add(new Edge(4, 7, 10));
		edges.add(new Edge(6, 8, 7));

		List<Edge> minimumSpaningForest = kruskalAlgorithm(n, edges);
	for (Edge edge : minimumSpaningForest) {
		System.out.println(edge);
	}

	}

	static List<Edge> kruskalAlgorithm(int n2, List<Edge> edges) {
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

		int[] parent = new int[n];
		for (int i = 0; i < n; i++) {
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
