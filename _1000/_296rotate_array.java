package _1000;

public class _296rotate_array {
    public static void reverse(int arr[] , int low , int high){
        while(low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
    public static void rotate(int arr[] , int n , int k){
        k = k % n;
        reverse(arr , 0 , n - 1);
        reverse(arr , 0 , k - 1);
        reverse(arr , k , n - 1);
    }
    public static void main(String args[]){

    }
}
