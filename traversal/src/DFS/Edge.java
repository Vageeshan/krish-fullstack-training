package DFS;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-04-08 06:44 pm Friday
 **/
public class Edge {

    private int source;
    private int dest;

    public Edge() {
    }

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }
}
