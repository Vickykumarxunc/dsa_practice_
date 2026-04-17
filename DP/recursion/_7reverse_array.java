package DP.recursion;

public class _7reverse_array {
    public static void swap(int arr[] , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void reverse(int arr[] , int i , int n){
        if(i >= n/2){
            return;
        }
        swap(arr , i , n - i - 1);
        reverse(arr , i + 1 , n);
    }
    public static void main(String[] args) {
        
    }
}
