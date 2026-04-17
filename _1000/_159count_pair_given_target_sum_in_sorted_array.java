package _1000;

public class _159count_pair_given_target_sum_in_sorted_array {
    public static int count_pair(int arr[] , int m , int target){
        int count = 0;
        int left = 0;
        int right = m - 1;

        while(left < right){
            int sum  = arr[left] + arr[right];
            if(sum == target){
                
                // count the frequency of duplicate element :
                // case1 : 
                if(arr[left] == arr[right]){
                    int n = right - left + 1;
                    count  += (n * (n + 1))/2;
                    break;
                }
                // case 2 : arr[left] != arr[right]
                int c1 = 1;
                int c2 = 1;
                
                while(left + 1 < right && arr[left] == arr[left + 1]){
                    c1++;
                    left++;
                }
                while(right - 1 > left && arr[right] == arr[right - 1]){
                    c2++;
                    right--;
                }
                count += c1 * c2;
                left++;
                right--;
            }
            else if(sum < target){
                left++;
            }
            else{
                right--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}
