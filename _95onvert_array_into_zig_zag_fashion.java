import java.util.Scanner;

public class _95onvert_array_into_zig_zag_fashion {
    public static void swap(int arr[] , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void rearrange(int arr[] , int n){

        for(int i = 1; i<n - 1; i+=2){

            // apply the condition of the rearrange : 
            if(arr[i] < arr[i - 1]){
                swap(arr , i , i - 1);
            }
            if(arr[i] < arr[i + 1]){
                swap(arr , i , i + 1);
            }
        }
    }
    public static void print(int arr[] , int n){
        for(int i = 0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
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
        print(arr, n);
        rearrange(arr, n);
        print(arr, n);
    }
}
/*
Given an array arr of distinct elements, the task is to rearrange the elements of the array in a zig-zag fashion so that the converted array should be in the below form: 

arr[0] < arr[1]  > arr[2] < arr[3] > arr[4] < . . . . arr[n-2] < arr[n-1] > arr[n]. 
 */
