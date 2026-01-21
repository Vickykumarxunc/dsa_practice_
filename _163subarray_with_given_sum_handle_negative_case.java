import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class _163subarray_with_given_sum_handle_negative_case {
    public static ArrayList<Integer> subarray_index(int arr[] , int target , int n){

        // negative case ko handle karne ke liye hum 
        // prefix sum and hashmap ka use karege : 
        HashMap<Integer , Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        int curr_sum = 0;
        for(int i = 0; i<n; i++){
            curr_sum += arr[i];

            // agar subarray starting se hi ho : 
            if(curr_sum == target){
                list.add(1);
                list.add(i + 1);
                return list;
            }
            // agar subarray kahi middle me ho : 
            if(map.containsKey(curr_sum - target)){
                list.add(map.get(curr_sum - target) + 2); // for the one based indexing  
                list.add(i + 1);
                return list;
            }
            // agar current sum map me present nahi hai : 
            // store only the first occurances : 
            if(!map.containsKey(curr_sum)){
                map.put(curr_sum , i);
            }
        }
        // agar subarray present hai hai : 
        list.add(-1);
        return list;
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
    }
}
