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
import java.util.Collections;
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

		List<Edge> edges3 = new ArrayList<>();
		edges3.add(new Edge(0, 2, 10));
		edges3.add(new Edge(0, 1, 12));
//		edges3.add(new Edge(1, 2, 10));
		edges3.add(new Edge(1, 3, 3));
		edges3.add(new Edge(2, 3, 6));

		dijkstra(edges3, 0);

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
			Edge reversedEdge = new Edge(edge.getEndNode(), edge.getStartNode(), edge.getWightl());
			graph.get(edge.getEndNode()).add(reversedEdge);
		}

		return graph;
	}

	private static void dijkstra(List<Edge> edges, int startingNode) {

		Map<Integer, List<Edge>> graph = buildGraph(edges);
		// use reverse order priority queue
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();

		boolean[] visitedNode = new boolean[graph.size()];
		int[] parent = new int[graph.size()];
		int[] distance = new int[graph.size()];
		// initialize the parent and distance array
		for (int i = 0; i < distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
			parent[i] = -1;
		}
		visitedNode[startingNode] = true;
		parent[startingNode] = startingNode;
		distance[startingNode] = 0;

		do {
			//TODO
			List<Edge> childOfStartingtNode = graph.get(startingNode);
			for (Edge edge : childOfStartingtNode) {
				if (!edge.isConnected()) {

					priorityQueue.add(edge);
				
				}
			}

			Edge currentEdge = priorityQueue.poll();
			currentEdge.setConnected(true);
			if (!visitedNode[currentEdge.getEndNode()]) {
				visitedNode[currentEdge.getEndNode()] = true;
				parent[currentEdge.getEndNode()] = currentEdge.getStartNode();

				int newDistance = distance[currentEdge.getStartNode()]+ currentEdge.getWightl();

				if (distance[currentEdge.getEndNode()] > newDistance) {
					distance[currentEdge.getEndNode()] = newDistance;
				}
				startingNode = currentEdge.getEndNode();
			}

		} while (priorityQueue.size() > 0);

		for (int i = 0; i < graph.size(); i++) {
			System.out.println("Node: " + i);
			System.out.println("distance: " + distance[i]);
			System.out.println("Parent: " + parent[i]);
			System.out.println();
		}
	}
}