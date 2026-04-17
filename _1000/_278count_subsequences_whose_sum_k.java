package _1000;
 

public class _278count_subsequences_whose_sum_k {
    public static int subsequences(int arr[] , int idx , int sum , int target){
        // base case : 
        if(idx == arr.length - 1){
            if(sum == target){
                return 1;
            }
            else{
                return 0;
            }
        }
        sum += arr[idx];
        int left = subsequences(arr, idx + 1, sum, target);

        // back track : 
        sum -= arr[idx];

        int right = subsequences(arr , idx + 1 , sum , target);

        return left + right;
    }
    public static int count_subsequences(int arr[] , int target){
        return subsequences(arr , 0 , 0 , target);
    }
    public static void main(String[] args) {
        
    }
}
