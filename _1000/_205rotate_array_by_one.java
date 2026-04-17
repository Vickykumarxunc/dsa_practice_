package _1000;

public class _205rotate_array_by_one {
    public static void rotate_by_one(int arr[] , int n){
        int last_element = arr[n - 1];
        for(int i = n - 1; i>0; i--){
            arr[i] = arr[i - 1];
        }
        arr[0] = last_element;
    }
    public static void main(String[] args) {
        
    }
}
