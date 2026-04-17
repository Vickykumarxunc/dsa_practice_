package _1000;

public class _39check_array_is_sorted {
    public static boolean check(int arr[] , int n){
        for(int i = 1; i<n; i++){
            if(arr[i] < arr[i - 1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
