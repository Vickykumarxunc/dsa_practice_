import java.util.Scanner;

public class _2second_largest {
    public static int find(int arr[] , int n ){

        // phle do variable lo 
        int max1 = Integer.MIN_VALUE;
        int max2 = max1;

        // traverse the array 
        for(int i = 0; i<n; i++){

            // agar current element max1 se bada hai to max1 ke value max2 me 
            // current element ko max1 me . 
            if(arr[i] > max1){
                max2 = max1;
                max1 = arr[i];
            }
            // agar current element ki value max1 se choti hai aur max2 se badi hai 
            // update the max2 
            if(arr[i] > max2 && arr[i] != max1){
                max2 = arr[i];
            }
        }
        // max2 is the second largest element : 
        return max2;
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
        int second_largest = find(arr , n);
        System.out.println("second largest elemet in the array = " + second_largest);
    }
}
/*
Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.

Note: The second largest element should not be equal to the largest element.

Input: arr[] = [12, 35, 1, 10, 34, 1]
Output: 34
Explanation: The largest element of the array is 35 and the second largest element is 34.

 */
