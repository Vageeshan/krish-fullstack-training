package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-04-08 06:45 pm Friday
 **/
public class Graph {
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;

    // Constructor
    public Graph(List<Edge> edges, int n) {
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // add edges to the undirected graph
        for (Edge edge : edges) {
            int src = edge.getSource();
            int dest = edge.getDest();

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}
