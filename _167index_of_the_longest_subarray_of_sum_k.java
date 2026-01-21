import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class _167index_of_the_longest_subarray_of_sum_k {
    public static ArrayList<Integer> index_of_longest_sub_array(int arr[] , int target , int n){

        // use the hashmap and prefix sum to handle the negative case : 
        HashMap<Integer , Integer> map = new HashMap<>();
        int curr_sum = 0;
        int max_len = 0;
        int start = -1;
        int end = -1;

        // traverse the array : 
        for(int i = 0; i<n; i++){
            
            // calculate the prefix sum  
            curr_sum += arr[i];

            // subarray start from the index 0  
            if(curr_sum == target){
                if(i + 1 > max_len){
                    max_len = i + 1;
                    start = 1; 
                    end = i + 1;
                }
            }
            // subarray in middle : 
            if(map.containsKey(curr_sum - target)){
                int length = i - map.get(curr_sum - target);
                if(length > max_len){
                    max_len = length;
                    start = map.get(curr_sum - target) + 2; // for the 1 baesd indexing  : 
                    end = i + 1;
                }
            }
            // store the first occurances only : i
            if(!map.containsKey(curr_sum)){
                map.put(curr_sum , i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();

        // if subarray is not present : 
        if(max_len == 0){
            ans.add(-1);
        }
        else{
            ans.add(start);
            ans.add(end);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the target sum : ");
        int target = sc.nextInt();
        ArrayList<Integer> ans = index_of_longest_sub_array(arr, target, n);
        System.out.println(ans);
    }
}
