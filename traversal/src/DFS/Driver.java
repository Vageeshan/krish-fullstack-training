package DFS;

import java.util.List;
import java.util.Stack;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-04-08 06:48 pm Friday
 **/
public class Driver {
    public static void iterativeDFS(Graph graph, int v, boolean[] discovered) {
        // create a stack used to do iterative DFS
        Stack<Integer> stack = new Stack<>();

        // push the source node into the stack
        stack.push(v);

        // loop till stack is empty
        while (!stack.empty()) {
            // Pop a vertex from the stack
            v = stack.pop();

            // if the vertex is already discovered yet, ignore it
            if (discovered[v]) {
                continue;
            }

            // we will reach here if the popped vertex `v` is not discovered yet;
            // print `v` and process its undiscovered adjacent nodes into the stack
            discovered[v] = true;
            System.out.print(v + " ");

            // do for every edge (v, u)
            List<Integer> adjList = graph.adjList.get(v);
            for (int i = adjList.size() - 1; i >= 0; i--) {
                int u = adjList.get(i);
                if (!discovered[u]) {
                    stack.push(u);
                }
            }
        }
    }
}
