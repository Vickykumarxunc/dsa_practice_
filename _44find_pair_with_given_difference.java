import java.util.*;
public class _44find_pair_with_given_difference {
    // two pointer appraoch : 
    public static boolean pair(int arr[] , int n , int target){

        // first sort the array : 
        Arrays.sort(arr);

        // take two pointer : 
        int left = 0;
        int right = 1;

        // traverse the array : 
        while(left < n && right < n){

            // calculate the diff : 
            int diff = arr[right] - arr[left];

            // check condition : 
            if(diff == target){
                return true;
            }
            else if(diff < target){
                right++;
            }
            else{
                left++;
            }
            if(left == right){
                right++; // it always ensure that right ahead of left : 
            }
        }
        // agar difference pair array me present nahi hai : 
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        System.out.println("enter the array element : ");
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the target difference : ");
        int target = sc.nextInt();
        boolean ans = pair(arr , n , target);
        System.out.println(ans);

    }
}
