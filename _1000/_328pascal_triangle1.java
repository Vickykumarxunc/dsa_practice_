package _1000;
import java.util.ArrayList;
public class _328pascal_triangle1 {
    public static ArrayList<ArrayList<Integer>> pascal_triangle(int n){

        // create a 2d array to store the pascal triangle : 
        int arr[][] = new int[n][n];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i<n; i++){

            // first and last element of each row is 1 : 
            arr[i][0] = 1;
            arr[i][i] = 1;

            for(int j = 1; j<i; j++){
                arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
            }
            // store into list : 
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j<=i; j++){
                temp.add(arr[i][j]);
            }
            list.add(temp);
        }
        return list;
    }
    public static ArrayList<ArrayList<Integer>> pascal(int n){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<n; i++){

            // each row of the pascal triangle : 
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j<=i; j++){

                // first and last element of each row is 1 : 
                if(j == 0 || j == i){
                    temp.add(1);
                }
                else{
                    temp.add(list.get(i - 1).get(j) + list.get(i - 1).get(j - 1));
                }
            }
            // add a row in the list : 
            list.add(temp);
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}