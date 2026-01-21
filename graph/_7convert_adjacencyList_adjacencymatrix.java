
import java.util.ArrayList;

public class _7convert_adjacencyList_adjacencymatrix {
    public static int[][] convert(ArrayList<ArrayList<Integer>> list){

        int n = list.size();
        int matrix[][] = new int[n][n];

        for(int i = 0; i<n; i++){
            for(int neighbour : list.get(i)){

                matrix[i][neighbour] = 1;
            }
        }
        return matrix;
    }
    public static void add_edges(ArrayList<ArrayList<Integer>> list , int u , int v){
        list.get(v).add(u);
        list.get(u).add(v);
    }
    public static void print(int matrix[][]){
        int n = matrix.length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
         
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int v = 5;
        for(int i = 0; i<v; i++){
            list.add(new ArrayList<>());
        }
        add_edges(list , 0 , 1);
        add_edges(list , 0 , 2);
        add_edges(list , 1 , 2);
        add_edges(list , 2 , 3);
        add_edges(list , 2 , 4);

        int matrix[][] = convert(list);
        print(matrix);
    }
}
