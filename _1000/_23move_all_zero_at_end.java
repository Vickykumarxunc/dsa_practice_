package _1000;

public class _23move_all_zero_at_end {
    public static void move(int arr[] , int n){
        int j = 0;
        for(int i = 0; i<n; i++){
            if(arr[i] != 0){
                arr[j] = arr[i];
                j++;
            }
        }
        while(j < n){
            arr[j] = 0;
            j++;
        }
    }
    public static void main(String[] args) {
        
    }
}
