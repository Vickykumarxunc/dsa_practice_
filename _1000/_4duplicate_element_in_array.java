package _1000;
import java.util.ArrayList;

public class _4duplicate_element_in_array {
    public static ArrayList<Integer> duplicate_element(int arr[] , int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int index = Math.abs(arr[i]) - 1;
            if(arr[index] < 0){
                list.add(Math.abs(arr[i]));
            }
            else{
                arr[index] = -1 * arr[index];
            }
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
