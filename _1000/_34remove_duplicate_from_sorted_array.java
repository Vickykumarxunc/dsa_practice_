package _1000;

public class _34remove_duplicate_from_sorted_array {
    public static int remove_duplicate(int arr[] , int n){
        int j = 0;
        for(int i = 1; i<n; i++){
            if(arr[i] != arr[i - 1]){
                arr[++j] = arr[i];
            }
        }
        return j + 1;
    }
    public static void main(String[] args) {
        
    }
}
