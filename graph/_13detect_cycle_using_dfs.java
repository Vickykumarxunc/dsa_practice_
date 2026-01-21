import java.util.ArrayList;

public class _13detect_cycle_using_dfs {
    public static boolean detect(ArrayList<ArrayList<Integer>> list, int v) {

        // create a visited array :
        boolean visited[] = new boolean[v];

        // graph can be a disconnected :
        for (int i = 0; i < v; i++) {

            // if node is not visited :
            // the apply the dfs :
            if (visited[i] == false) {
                if (dfs(list, i, -1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> list, int node, int parent, boolean visited[]) {

        // mark as visited :
        visited[node] = true;

        // now traverse the neighbour :
        for (int neighbour : list.get(node)) {

            // agar neighbour unvisited hai to use traverse karo :
            if (visited[neighbour] == false) {
                if (dfs(list, neighbour, node, visited)) {
                    return true;
                }
            }
            // agar neigh vour visited hai :
            else if (neighbour != parent) {
                return true;
            }
        }
        // if cycle is not present :
        return false;
    }

    public static void main(String[] args) {

    }
}
