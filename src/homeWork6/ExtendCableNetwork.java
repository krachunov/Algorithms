/**
 * Problem 1. Extend a Cable Network
A cable networking company plans to extend its existing cable network by connecting as many customers as possible within a fixed budget limit.
The company has calculated the cost of building some prospective connections.
You are given the existing cable network (a set of customers and connections between them)
along with the estimated connection costs between some pairs of customers and prospective customers. Example:
 */
package homeWork6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ExtendCableNetwork {

	static List<Edge> createEdge(int numberOfEdge) {
		Scanner sc = new Scanner(System.in);
		int firstNode;
		int secondNode;
		int wightl;
		String connected = "connected";
		List<Edge> edge = new ArrayList<Edge>();

		for (int i = 0; i < numberOfEdge; i++) {
			System.out
					.println("Enter the fisrt node/second node and the price");
			String[] line = sc.nextLine().split(" ");
			firstNode = Integer.valueOf(line[0]);
			secondNode = Integer.valueOf(line[1]);
			wightl = Integer.valueOf(line[2]);
			if (line.length > 3) {
				if (connected.contains(line[3])) {
					edge.add(new Edge<Integer>(firstNode, secondNode, wightl,
							true));
				}
			} else {
				edge.add(new Edge<Integer>(firstNode, secondNode, wightl));
			}

			// TODO crate graph
		}

		return edge;
	}

	static Map<Integer, List<Edge>> buildGraph(List<Edge> edges) {
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
			// TODO - 1:14
		}
		return graph;
	}

	private static void prim(List<Edge> graph) {
		MyBinaryHeaps priorityQueue = new MyBinaryHeaps<>();

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of edge");
		List<Edge> edges = createEdge(sc.nextInt());
		Map<Integer, List<Edge>> graph = buildGraph(edges);
		
		System.out.println(graph.size());
		

	}
}
