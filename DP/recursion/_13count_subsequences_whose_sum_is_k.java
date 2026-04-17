package DP.recursion;

public class _13count_subsequences_whose_sum_is_k {
    // time = 2^n
    public static int count(int arr[] , int idx , int k , int sum){
        if(idx == arr.length){
            if(sum == k){
                return 1;
            }
            return 0;
        }
        // take : 
        sum += arr[idx];
        int left = count(arr , idx + 1 , k , sum);

        // back track : 
        sum -= arr[idx];

        // not take : 
        int right = count(arr , idx + 1 , k , sum);

        // return count : 
        return left + right;
    }
    public static void main(String[] args) {
        int arr[] = {1 , 2 , 1};
        int k = 2;
        int sum = 0;
        int count = count(arr , 0 , k , sum);
        System.out.println("number of subsequences = " + count);
    }
}
