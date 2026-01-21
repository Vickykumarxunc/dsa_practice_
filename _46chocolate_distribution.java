import java.util.*;
public class _46chocolate_distribution {
    public static int findMinDiff(int arr[] , int n , int m){

        // first sort the array : 
        Arrays.sort(arr);

        // initially difference of a first sliding window : 
        int min = arr[0];
        int max = arr[m - 1];
        int diff = max - min;
        // edge case : 
        // agar no of student no of paceket ka barabar ho to sabko ek ek packet milege to sare packet distribute ho jayege : 
        if(m == n){
            return diff;
        }

        // now apply the sliding window : 
        int j = 1;
        for(int i = m; i<n; i++){
            int current_diff = arr[i] - arr[j];
            diff = Math.min(current_diff , diff);
            j++;
        }
        return diff;
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
        System.out.println("enter the no of student : ");
        int m = sc.nextInt();

        int ans = findMinDiff(arr, n, m);
        System.out.println("minimum difference = " + ans);
    }
}
/*
Given an array arr[] of positive integers, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets among m students such that -
      i. Each student gets exactly one packet.
     ii. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum and return that minimum possible difference.
 */
 
