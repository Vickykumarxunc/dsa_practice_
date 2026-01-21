
import java.util.ArrayList;

public class _6convert_adjacency_matrix_to_adjacency_list {
    public static ArrayList<ArrayList<Integer>> convert(int matrix[][]){

        int n = matrix.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix.length; j++){
                if(matrix[i][j] == 1 && i != j){ // for igonorig the self loop use i != j
                    list.get(i).add(j);
                }
            }
        }
        return list;
    }
    public static void print(ArrayList<ArrayList<Integer>> list){
        for(int i = 0; i<list.size(); i++){
            System.out.print(i + " -> ");
            for(int neighbour : list.get(i)){
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        
        int matrix[][] = {
            {0 , 1 , 1 , 0 , 0},
            {1 , 0 , 1 , 0 , 0},
            {1 , 1 , 0 , 1 , 1},
            {0 , 0 , 1 , 0 , 0},
            {0 , 0 , 1 , 0 , 0}
        };

        ArrayList<ArrayList<Integer>> list = convert(matrix);
        print(list);

    }
}
