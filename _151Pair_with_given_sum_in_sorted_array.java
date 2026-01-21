
import java.util.Scanner;

public class _151Pair_with_given_sum_in_sorted_array {
    public static int count(int arr[] , int n , int target){
        int count = 0;

        // apply the two pointer approach  : 
        int left = 0;
        int right = n - 1;

        while(left <= right){
            int sum = arr[left] + arr[right];
            
            // if sum is lesser go right side : 
            if(sum < target){
                left++;
            }
            // if sum is larger go to left side : 
            else if(sum > target){
                right--;
            }
            // if sum is equal : 
            else{
                int count1 = 0;
                int count2 = 0;
                int element1 = arr[left];
                int element2 = arr[right];

                // count the frequency of the first element of pair : 
                while(left <= right && arr[left] == element1){
                    left++;
                    count1++;
                }
                // count the frequency of the second element of pair : 
                while(left <= right && arr[right] == element2){
                    right--;
                    count2++;
                }
                // if both the element are same , then count of 
                // pair = the number of way to choose 2 element among the count1 element : 
                if(element1 == element2){
                    count += (count1 * (count1 - 1))/2;
                }
                // if the element are different then count the 
                // pair = product of the count of both element ;
                else{
                    count += (count1 * count2);
                }
            }
        }
        return count;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        System.out.println("enter the array element : ");
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the target : ");
        int target = sc.nextInt();

        int ans = count(arr , n , target);
        System.out.println("no of pair present = " + ans);
    }
}
