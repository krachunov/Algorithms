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

public class ExtendCableNetwork {

	static List<Edge> createEdge(int numberOfEdge) {
		Scanner sc = new Scanner(System.in);
		int firstNode;
		int secondNode;
		int wightl;
		List<Edge> edge = new ArrayList<Edge>();
		for (int i = 0; i < numberOfEdge; i++) {
			String[] line = sc.nextLine().split(" ");
			firstNode = Integer.valueOf(line[0]);
			secondNode = Integer.valueOf(line[1]);
			wightl = (line.length >= 2 ? Integer.valueOf(line[1]) : -1);
			edge.add(new Edge<Integer>(firstNode, secondNode, wightl));

			//TODO crate graph
		}

		return null;
	}

	static Map<Integer, List<Edge>> buildGraph() {

		return null;
	}

	public static void main(String[] args) {

		List<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge<Integer>(1, 1, 3));

		MyBinaryHeaps graph = new MyBinaryHeaps();
		graph.enqueue(new Edge<Integer>(1, 1, 5));
		graph.enqueue(new Edge<Integer>(1, 2, 3));
		graph.enqueue(new Edge<Integer>(2, 3, 1));
		graph.enqueue(new Edge<Integer>(4, 5, 32));

		while (graph.isEmpty()) {
			System.out.println(graph.dequeue().toString());
		}

	}
}
