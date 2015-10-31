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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

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

		List<Edge> minimumSpaningForest = reliablePath(edges, 0);

		for (Edge edge : minimumSpaningForest) {
			System.out.println(edge);
		}

	}

	private static Map<Integer, List<Edge>> buildGraph(List<Edge> edges) {

		Map<Integer, List<Edge>> graph = new TreeMap<>();
		for (Edge edge : edges) {
			if (!graph.containsKey(edge.getStartNode())) {
				graph.put((Integer) edge.getStartNode(), new ArrayList<Edge>());
			}
			graph.get(edge.getStartNode()).add(edge);
			if (!graph.containsKey(edge.getEndNode())) {
				graph.put((Integer) edge.getEndNode(), new ArrayList<Edge>());
			}
			graph.get(edge.getEndNode()).add(edge);
			// TODO
		}

		return graph;
	}

	private static List<Edge> reliablePath(List<Edge> edges, int startingNode) {
		Map<Integer, List<Edge>> graph = buildGraph(edges);
		MyBinaryHeaps<Edge> priorityQueue = new MyBinaryHeaps<>();

		boolean[] visitedNode = new boolean[edges.size()];
		int[] distance = new int[edges.size()];
		for (int i = 0; i < distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		visitedNode[startingNode] = true;
		distance[startingNode] = 0;

		do {
			List<Edge> childOfStartingtNode = graph.get(startingNode);
			for (Edge edge : childOfStartingtNode) {
				priorityQueue.enqueue(edge);
			}
			Edge currentEdge = priorityQueue.extractMin();
			if (!visitedNode[currentEdge.getEndNode()]) {
				visitedNode[currentEdge.getEndNode()] = true;

				if (distance[currentEdge.getEndNode()] > currentEdge
						.getWightl()) {
					distance[currentEdge.getEndNode()] = currentEdge
							.getWightl();
					// TODO distance = distance current node + distance from
					// parentNode to the current node;

				}
			}

		} while (priorityQueue.getCount() > 0);

		return null;
	}
}