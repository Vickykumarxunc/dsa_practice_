
import java.util.Scanner;

public class _170jump_game {
    public static boolean can_reach(int arr[] , int n){

        // edge case : 
        if(arr[0] == 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        // maintain the max reach and steps : 
        int max_reach = arr[0]; // maximum kitna aage ja sakta hoon 
        int step = arr[0]; // kitne step bache hai : 

        // array ke har element par khade hokar ye check karege 
        // ki mai ya or kitna dur ja sakta hoon : 
        for(int i = 1; i<n; i++){
 
            // maximum reaching point : 
            if(i >= max_reach){
                return false;
            }
            // update the maximum reahchable index : 
            max_reach = Math.max(max_reach , i + arr[i]);
        }
        // if we reach the last point of the array : 
        return true;
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
        boolean ans  = can_reach(arr, n);
        System.out.println("can reach the last index :  " + ans);

    }
}

/*
Given a array of positive integers arr, where each element denotes the maximum length of jump you can cover. Find out if you can make it to the last index starting from the first index of the list, return true if you can reach the last index.
 */