package _1000;

public class _169roof_top {
    public static int maximum_number_of_consecutive_step(int arr[] , int n){
        int max_count = 0;
        int curr_count = 0;
        for(int i = 1; i<n; i++){
            if(arr[i] > arr[i - 1]){
                curr_count++;
            }
            max_count = Math.max(max_count , curr_count);
        }
        return max_count;
    }
    public static void main(String[] args) {
        
    }
}
