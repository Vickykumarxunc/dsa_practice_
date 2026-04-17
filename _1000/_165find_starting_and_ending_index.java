package _1000;
import java.util.ArrayList;
public class _165find_starting_and_ending_index {
    public static ArrayList<Integer>  first_and_last_index_of_x(int arr[] , int n , int x){
        int first_index = -1;
        int last_index = -1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(arr[i] == x){
                if(first_index == -1){
                     first_index = i;
                }
                last_index = i;
            }
        }
        list.add(first_index);
        list.add(last_index);
        return list;
    }
    public static void main(String[] args) {
        
    }
}
