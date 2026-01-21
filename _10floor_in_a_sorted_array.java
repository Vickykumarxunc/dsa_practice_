import java.util.Scanner;

public class _10floor_in_a_sorted_array {
    public static int find(int arr[] , int target , int n){
        
        int low = 0;
        int high = n - 1;
        int floor = -1;

        // apply binary search : 
        while(low <= high){

            int mid = low + (high - low)/2;
            if(arr[mid] <= target){
            
                floor = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return floor;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the target element : ");
        int target = sc.nextInt();
        int ans = find(arr, target, n);
        System.out.println(ans);
    }
}

/*
Given a sorted array arr[] and an integer x, find the index (0-based) of the largest element in arr[] that is less than or equal to x. This element is called the floor of x. If such an element does not exist, return -1.

Note: In case of multiple occurrences of floor of x, return the index of the last occurrence.
 */
