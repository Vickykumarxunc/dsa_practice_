package _1000;

public class _6equilibrium_point_in_array {
    public static int equilibrium_point(int arr[] , int n){
        int right_sum = 0;
        for(int i = 0; i<n; i++){
            right_sum += arr[i];
        }
        int left_sum = 0;
        for(int i = 0; i<n; i++){
            right_sum -= arr[i];
            if(left_sum == right_sum){
                return i;
            }
            left_sum += arr[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        
    }
}
