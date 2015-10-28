/**
 * Problem 1. Extend a Cable Network
A cable networking company plans to extend its existing cable network by connecting as many customers as possible within a fixed budget limit.
The company has calculated the cost of building some prospective connections.
You are given the existing cable network (a set of customers and connections between them)
along with the estimated connection costs between some pairs of customers and prospective customers. Example:
 */
package homeWork6;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.RowFilter.Entry;

@SuppressWarnings("rawtypes")
public class ExtendCableNetwork {

	List<Edge> edges;
	Map<Integer, List<Edge>> graph;
	Map<Integer, List<Edge>> spanningTreeNode;
	List<Edge> spaningTreeEdge;

	public ExtendCableNetwork() {
		spanningTreeNode = new HashMap<Integer, List<Edge>>();
		spaningTreeEdge = new ArrayList<Edge>();
	}

	private void createEdge(int numberOfEdge) {
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
					edge.add(new Edge(firstNode, secondNode, wightl, true));
				}
			} else {
				edge.add(new Edge(firstNode, secondNode, wightl));
			}
		}

		setEdges(edge);
		sc.close();
	}

	private void buildGraph(List<Edge> edges) {
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
		}

		setGraph(graph);
	}

	public void prim() {
		for (Edge edge : getEdges()) {
			if (!getSpanningTree().containsKey(edge.getStartNode())) {
				prim(edge.getStartNode());
			}
		}
	}

	private void prim(int startNode) {
		MyBinaryHeaps<Edge> priorityQueue = new MyBinaryHeaps<>();

		List<Edge> childEdge = graph.get(startNode);
		for (int i = 0; i < childEdge.size(); i++) {
			priorityQueue.enqueue(childEdge.get(i));
		}
		getSpanningTree().put(startNode, null);
		// TODO
		while (priorityQueue.getCount() > 0) {

			Edge smallestEdge = priorityQueue.extractMin();
			if (getSpanningTree().containsKey(smallestEdge.getStartNode())
					^ getSpanningTree().containsKey(smallestEdge.getEndNode())) {
				getSpaningTreeEdge().add(smallestEdge);

				int nonTreeNode = (getSpanningTree().containsKey(
						smallestEdge.getStartNode()) ? smallestEdge
						.getEndNode() : smallestEdge.getStartNode());
				getSpanningTree().put(nonTreeNode, null);

				childEdge = graph.get(nonTreeNode);
				for (int i = 0; i < childEdge.size(); i++) {
					priorityQueue.enqueue(childEdge.get(i));
				}

			}
		}
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public Map<Integer, List<Edge>> getGraph() {
		return graph;
	}

	public void setGraph(Map<Integer, List<Edge>> graph) {
		this.graph = graph;
	}

	public Map<Integer, List<Edge>> getSpanningTree() {
		return spanningTreeNode;
	}

	public void setSpanningTree(Map<Integer, List<Edge>> spanningTree) {
		this.spanningTreeNode = spanningTree;
	}

	public List<Edge> getSpaningTreeEdge() {
		return spaningTreeEdge;
	}

	public void setSpaningTreeEdge(List<Edge> spaningTreeEdge) {
		this.spaningTreeEdge = spaningTreeEdge;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ExtendCableNetwork exCabNet = new ExtendCableNetwork();

		System.out.println("Enter the number of edge");
		exCabNet.createEdge((sc.nextInt()));
		sc.close();
		exCabNet.buildGraph(exCabNet.getEdges());
		exCabNet.prim();
		System.out.println("");

		// for (java.util.Map.Entry<Integer, List<Edge>> entry : exCabNet
		// .getSpanningTree().entrySet()) {

		System.out.println(exCabNet.getSpaningTreeEdge());
		// }
	}
}
