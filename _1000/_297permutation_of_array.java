package _1000;
import java.util.ArrayList;
public class _297permutation_of_array {
    public static void find(int arr[] , ArrayList<ArrayList<Integer>> ans , ArrayList<Integer> list , boolean visited[]){
        
        // base case : 
        if(list.size() == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i<arr.length; i++){
            if(visited[i] == false){
                visited[i] = true;
                list.add(arr[i]);
                find(arr , ans , list , visited);

                // backtrack : 
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> permute(int arr[] , int n){

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        // ek visited array banao ye track karege ki kon element current permutation me add ho gaya : 
        boolean visited[] = new boolean[n];
        find(arr , ans , list , visited);
        return ans;
    }
    public static void main(String args[]){

    }
}
