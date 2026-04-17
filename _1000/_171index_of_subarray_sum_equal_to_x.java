package _1000;
import java.util.ArrayList;

public class _171index_of_subarray_sum_equal_to_x {
    // only for positive element :
    public static ArrayList<Integer> index_of__first_subarray(int arr[] , int n , int target){
        ArrayList<Integer> list = new ArrayList<>();
        int j = 0;
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += arr[i];
            
            while(sum > target){
                sum -= arr[j--];
            }
            if(sum == target){
                list.add(j + 1);
                list.add(i + 1);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
