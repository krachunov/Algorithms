package homeWork5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DistanceBetweenVertices {

	static void adjacencyLists(List list, int num) {

		for (int i = 0; i < num; i++)
			list.set(i, new ArrayList<Integer>());
	}

	public static void main(String[] args) {

		int numberOfNode = 5;
		List<List<Integer>> graph = new ArrayList<List<Integer>>();
		adjacencyLists(graph, numberOfNode);
		
	}
}
