package _1000;

import java.util.ArrayList;

public class _238bridges_in_a_graph {
    public static void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> ans, boolean visited[],
            int time_in[], int low[], int node, int parent, int timer[]) {

        // first mark the node is visited :
        visited[node] = true;
        time_in[node] = timer[0];
        low[node] = timer[0];
        timer[0]++;

        // traverse the neighbour :
        for (int neighbour : adj.get(node)) {

            // agar neighbour parent ke equal hai to to kuch mat karo :
            if (neighbour == parent) {
                continue;
            }
            if (visited[neighbour] == false) {
                // agar neighbour unvisited hai :
                // call the dfs
                dfs(adj, ans, visited, time_in, low, neighbour, node, timer);

                // backtrack karte vakt
                // parent ko chod ke low of node of update karo

                // minimum lowest time insert of all adjacenet node apart from parent :
                low[node] = Math.min(low[node], low[neighbour]);

                // node --- neighbour
                if (low[neighbour] > time_in[node]) {
                    // it is critical connections store it
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(neighbour);
                    temp.add(node);
                    ans.add(temp);
                }
            } else {
                low[node] = Math.min(low[node], low[neighbour]);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> critical_connections(ArrayList<ArrayList<Integer>> connections, int V) {

        // first create a graph :
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < connections.size(); i++) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        // create a visited array :
        boolean visited[] = new boolean[V];

        // create a time in array (kis time par node visit hui :)
        int time_in[] = new int[V];

        // create a low array :
        int low[] = new int[V];

        // create a list to store the critical connections :
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int timer[] = new int[] { 1 };

        // apply the dfs :
        dfs(adj, ans, visited, time_in, low, 0, -1, timer);
        return ans;
    }

    public static void main(String[] args) {

    }
}
