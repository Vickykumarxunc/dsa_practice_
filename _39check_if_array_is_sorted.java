import java.util.Scanner;

public class _39check_if_array_is_sorted {
    public static boolean isSorted(int arr[] , int n){
        for(int i = 1; i<n; i++){
            if(arr[i] < arr[i - 1]){
                return false;
            }
        }
        return true;
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
   } 
}

/*
Given an array arr[], check whether it is sorted in non-decreasing order. Return true if it is sorted otherwise false.
 */
