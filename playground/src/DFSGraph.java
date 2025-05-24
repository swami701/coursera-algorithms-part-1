import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Graph {
    private int[] vertices;
    private List<Integer>[] adjacencyList;

    public Graph(int n) {
        vertices = new int[n];
        adjacencyList = new ArrayList[n];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
        adjacencyList[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adjacencyList[v];
    }

    public int E() {
        int edges = 0;
        for (int i : vertices) {
            edges += adjacencyList[i].size();
        }
        return edges / 2;
    }

    public int V() {
        return vertices.length;
    }
}

class DFS {
    private boolean[] marked;
    private int[] path;
    private int source;

    public DFS(Graph graph, int source) {
        this.source = source;
        marked = new boolean[graph.V()];
        path = new int[graph.V()];
        for (int i = 0; i < path.length; i++) {
            path[i] = -1;
        }
        dfs(graph, source);
    }

    private void dfs(Graph graph, int source) {
        if (marked[source]) {
            return;
        }
        marked[source] = true;
        for (int i : graph.adj(source)) {
            path[i] = source;
            dfs(graph, i);
        }
    }

    public boolean isConnectedTo(int dest) {
        return marked[dest];
    }

    public Iterable<Integer> path(int dest) {
        if (!isConnectedTo(dest)) {
            return Collections.emptyList();
        }
        Stack<Integer> stack = new Stack<>();
        int idx = dest;
        stack.push(idx);
        while (path[idx] != source) {
            stack.push(path[idx]);
            idx = path[idx];
        }
        stack.push(source);
        return stack;
    }
}

public class DFSGraph {
    public static void main(String[] args) {
        Graph graph = new Graph(13);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(0, 5);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(6, 4);
        graph.addEdge(7, 8);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);

        DFS dfs = new DFS(graph, 0);
        System.out.println("isConnected: "+dfs.isConnectedTo(6));
        System.out.println("isConnected: "+dfs.isConnectedTo(7));
        System.out.println("isConnected: "+dfs.isConnectedTo(3));
        System.out.println("isConnected: "+dfs.isConnectedTo(4));
        System.out.println("Path: "+dfs.path(6));
        System.out.println("Path: "+dfs.path(7));
        System.out.println("Path: "+dfs.path(3));
        System.out.println("Path: "+dfs.path(4));
    }
}
