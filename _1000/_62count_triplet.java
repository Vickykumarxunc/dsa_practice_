package _1000;
import java.util.Arrays;
public class _62count_triplet{
    public static int count(int arr[] , int n){
        Arrays.sort(arr);
        int count = 0;
        for(int i =  n - 1; i>= 2; i--){
            int left = 0;
            int right = i - 1;
            while(left < right){
                int sum = arr[left] + arr[right];
                if(sum == arr[i]){
                    count++;
                    left++;
                    right--;
                }
                else if(sum < arr[i]){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}
