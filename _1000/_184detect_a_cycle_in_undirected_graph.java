package _1000;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class pair {
    int node;
    int parent;

    pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class _184detect_a_cycle_in_undirected_graph {
    // detect cycle using the dfs :
    public static boolean detect_cycle_using_dfs(ArrayList<ArrayList<Integer>> graph, int v) {
        boolean visited[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (visited[i] == false) {
                if (dfs(graph, visited, i, -1) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean visited[], int node, int parent) {
        visited[node] = true;
        for (int neighbour : graph.get(node)) {
            if (visited[neighbour] == false) {
                if (dfs(graph, visited, neighbour, node) == true) {
                    return true;
                }
            } else if (neighbour != parent) {
                return true;
            }
        }
        return false;
    }

    // detect cycle using the dfs :
    public static boolean detect_cycle_using_bfs(ArrayList<ArrayList<Integer>> graph, int v) {
        boolean visited[] = new boolean[v];
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0, -1));
        visited[0] = true;
        while (!q.isEmpty()) {
            int node = q.peek().node;
            int parent = q.peek().parent;
            for (int neighbour : graph.get(node)) {
                if (visited[neighbour] == false) {
                    q.add(new pair(neighbour, node));
                    visited[neighbour] = true;
                } else if (neighbour != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
