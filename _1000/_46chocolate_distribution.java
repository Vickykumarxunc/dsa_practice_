package _1000;
import java.util.Arrays;

public class _46chocolate_distribution {
    public static int chocolate_distribution(int arr[] , int n , int k){
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        for(int i = k - 1; i < n; i++){
             diff = Math.min(diff , arr[i] - arr[k - i - 1]);
        }
        return diff;
    }
    public static void main(String[] args) {
        
    }
}
