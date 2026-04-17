package _1000;
import java.util.HashMap;

public class _318longest_sub_array_with_sum_zero {
    public static int maxLen(int arr[] , int n){

        // use the hashMap 
        // jo store karege current sum ka index : 
        HashMap<Integer , Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;

        for(int i = 0; i<n; i++){
            sum += arr[i];

            // agar subarray index zero se hi start ho gaya : 
            if(sum == 0){
                maxLen = i + 1;
            }
            // agar current sum map ke ander present hai 
            // matlab beeck me kahi zero sum subarray present hai ; 
            if(map.containsKey(sum)){
                maxLen = Math.max(maxLen , i - map.get(sum));
            }
            // agar current sum map me present nahi hai 
            else{
                map.put(sum , i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        
    }
}
