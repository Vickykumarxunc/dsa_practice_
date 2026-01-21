import java.util.Scanner;

public class _101element_with_left_side_smaller_and_right_side_greater {

    public static int findElement(int arr[] , int n){

        // create a two array 
        // left max which contain the left max value
        // right min which contain the right min value : 
        int leftMax[] = new int[n];
        int rightMin[] = new int[n];

        // left max fill : 
        leftMax[0] = arr[0];
        for(int i = 1; i<n; i++){
            leftMax[i] = Math.max(leftMax[i - 1] , arr[i]);
        }

        // right min fill : 
        rightMin[n-1] = arr[n - 1];
        for(int i = n - 2; i>= 0; i--){
            rightMin[i] = Math.min(rightMin[i + 1] , arr[i]);
        }

        // check condition : 
        for(int i = 1; i<n - 1; i++){
            if(leftMax[i - 1] < arr[i] && arr[i] < rightMin[i + 1]){
                return arr[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = findElement(arr, n);
        System.out.println(ans);
    }
}
/*
Given an unsorted array of arr. Find the first element in an array such that all of its left elements are smaller and all right elements of its are greater than it.

Note: Return -1 if there is no such element.
 */
