
public class _1adjacency_matrix {
    // add edges in the undirected graph : 
    public static void add_edges(int matrix[][] , int u , int v){
        matrix[u][v] = 1; // u->v
        matrix[v][u] = 1; // v->u
    }
    // print the graph : 
    public static void print(int matrix[][] , int v){
        for(int i = 0; i<v; i++){
            for(int j = 0; j<v; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){

        // V is the  number of vertices
        int V = 5;
        int matrix[][] = new int[V + 1][V + 1];

        // add edges : 
        add_edges(matrix , 1 , 3);
        add_edges(matrix , 1 , 2);
        add_edges(matrix , 2 , 5);
        add_edges(matrix , 4 , 5);
        add_edges(matrix , 3 , 4);

        // print the graph :
        print(matrix, V + 1);

    }
}

/*
Space: O(V²)
time : v * e
 */
