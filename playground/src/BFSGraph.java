import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Graph {
    private int V[];
    private List<Integer>[] adjList;

    public Graph(int size) {
        V = new int[size];
        adjList = new ArrayList[size];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjList[v].add(w);
        adjList[w].add(v);
    }

    public int V() {
        return V.length;
    }

    public Iterable<Integer> adj(int v) {
        return adjList[v];
    }
}

class BFS {
    private int[] distTo;
    private int[] path;
    private int source;

    public BFS(Graph g, int source) {
        this.source = source;
        path = new int[g.V()];
        distTo = new int[g.V()];
        bfs(g, source);
    }

    private void bfs(Graph g, int source) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int i : g.adj(v)) {
                if (distTo[i] == 0) {
                    queue.offer(i);
                    distTo[i] = 1 + distTo[v];
                    path[i] = v;
                }
            }
        }
    }

    public boolean isConnectedTo(int dest) {
        return distTo[dest] > 0;
    }

    public Iterable<Integer> path(int dest) {
        if (!isConnectedTo(dest)) {
            return Collections.emptyList();
        }
        Stack<Integer> stack = new Stack<>();
        int idx = dest;
        stack.push(dest);
        while (path[idx] != source) {
            stack.push(path[idx]);
            idx = path[dest];
        }
        stack.push(source);
        return stack;
    }

    public int distTo(int dest) {
        return distTo[dest];
    }
}

public class BFSGraph {
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

        BFS bfs = new BFS(graph, 0);
        System.out.println("isConnected: " + bfs.isConnectedTo(6));
        System.out.println("isConnected: " + bfs.isConnectedTo(7));
        System.out.println("isConnected: " + bfs.isConnectedTo(3));
        System.out.println("isConnected: " + bfs.isConnectedTo(4));
        System.out.println("Path: " + bfs.path(6));
        System.out.println("Path: " + bfs.path(7));
        System.out.println("Path: " + bfs.path(3));
        System.out.println("Path: " + bfs.path(4));
        System.out.println("Distance: " + bfs.distTo(6));
        System.out.println("Distance: " + bfs.distTo(7));
        System.out.println("Distance: " + bfs.distTo(3));
        System.out.println("Distance: " + bfs.distTo(4));
    }
}
