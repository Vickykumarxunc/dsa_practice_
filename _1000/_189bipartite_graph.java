package _1000;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _189bipartite_graph {
    // bipartite graph using dfs :
    public static boolean bipartite_graph(ArrayList<ArrayList<Integer>> graph, int v) {

        int color[] = new int[v];
        for (int i = 0; i < v; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < v; i++) {

            if (color[i] == -1) {
                if (dfs(graph, color, i, 0) == false) {
                    return false;
                }
            }

        }
        return true;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> graph, int color[], int node, int col) {

        color[node] = col;
        for (int neighbour : graph.get(node)) {
            if (color[neighbour] == -1) {
                if (dfs(graph, color, neighbour, 1 - col) == false) {
                    return false;
                }
            } else if (color[neighbour] == color[node]) {
                return false;
            }
        }
        return true;
    }

    // bipartite graph using the bfs :
    public static boolean bipartite_graph_using_bfs(ArrayList<ArrayList<Integer>> graph, int v) {
        int color[] = new int[v];
        for (int i = 0; i < v; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                if (bfs(graph, color, i, 0) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean bfs(ArrayList<ArrayList<Integer>> graph, int color[], int start, int col) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = col;
        while (!q.isEmpty()) {
            int node = q.remove();
            for (int neighbour : graph.get(node)) {
                if (color[neighbour] == -1) {
                    q.add(neighbour);
                    color[neighbour] = 1 - color[node];
                } else if (color[neighbour] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
