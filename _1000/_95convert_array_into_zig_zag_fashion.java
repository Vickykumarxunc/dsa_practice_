package _1000;

public class _95convert_array_into_zig_zag_fashion {
    public static void rearrange(int arr[] , int n){
        for(int i = 1; i<n - 1; i+=2){
            if(arr[i] < arr[i + 1]){
                swap(arr , i , i + 1);
            }
            if(arr[i] < arr[i - 1]){
                swap(arr , i , i - 1);
            }
        }
    }
    public static void swap(int arr[] , int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        
    }
}
