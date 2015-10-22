package homeWork5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DistanceBetweenVertices {

	static void adjacencyLists(List<List<Integer>> list, int num) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < num; i++) {
			list.add(new ArrayList<Integer>());
		}
		System.out.println("enter the parent");
		int parent = sc.nextInt();
		System.out.println("enter the child");
		int child = sc.nextInt();
		addEdge(list, parent, child);

	}

	static void addEdge(List list, int i, int j) {
		List node = (List) list.get(i);
		node.add(j);
	}

	public static void main(String[] args) {

		int numberOfNode = 2;
		List<List<Integer>> graph = new ArrayList<List<Integer>>();
		adjacencyLists(graph, numberOfNode);

	}
}
