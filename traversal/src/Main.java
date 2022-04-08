import BFS.BFSTraversalDemo;
import DFS.Driver;
import DFS.Edge;
import DFS.Graph;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //BFS
        BFSTraversalDemo bfsTraversalDemo = new BFSTraversalDemo(6);
        bfsTraversalDemo.insertEdge(0, 1);
        bfsTraversalDemo.insertEdge(0, 3);
        bfsTraversalDemo.insertEdge(0, 4);
        bfsTraversalDemo.insertEdge(4, 5);
        bfsTraversalDemo.insertEdge(3, 5);
        bfsTraversalDemo.insertEdge(1, 2);
        bfsTraversalDemo.insertEdge(1, 0);
        bfsTraversalDemo.insertEdge(2, 1);
        bfsTraversalDemo.insertEdge(4, 1);
        bfsTraversalDemo.insertEdge(3, 1);
        bfsTraversalDemo.insertEdge(5, 4);
        bfsTraversalDemo.insertEdge(5, 3);
        System.out.println("Breadth First Traversal for the graph is:");
        bfsTraversalDemo.BFS(0);

        //DFS
        // List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(
                // Notice that node 0 is unconnected
                new Edge(1, 2), new Edge(1, 7), new Edge(1, 8), new Edge(2, 3),
                new Edge(2, 6), new Edge(3, 4), new Edge(3, 5), new Edge(8, 9),
                new Edge(8, 12), new Edge(9, 10), new Edge(9, 11)
                // (6, 9) introduces a cycle
        );

        // total number of nodes in the graph (labelled from 0 to 12)
        int n = 13;

        // build a graph from the given edges
        Graph graph = new Graph(edges, n);

        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[n];

        // Do iterative DFS traversal from all undiscovered nodes to
        // cover all connected components of a graph
        for (int i = 0; i < n; i++) {
            if (!discovered[i]) {
                Driver.iterativeDFS(graph, i, discovered);
            }
        }
    }
}
