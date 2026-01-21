
import java.util.Scanner;

public class _169minimum_jump {
    public static int minimum_jump(int arr[] , int n){

        // edge case : 
        if(n <= 1){
            return  0;
        }
        // hum first position se aage ja hi nahi sakte : 
        if(arr[0] == 0){
            return -1;
        }
        int max_reach = arr[0]; // ab tak maximum index jahan tak pahuch sakta hai : 
        int steps = arr[0]; // current jump me kitne step bache 
        int jumps = 1; // total kitne jump liye gaye 

        for(int i = 1; i<n; i++){

            // agar hum last me pahuch gaye : 
            if(i == n - 1){
                return jumps;
            }
            // ab hum har ek index par khade hokar ye dekhege ki hum isse aage or kaha tak ja sakte hai : 
            max_reach = Math.max(max_reach , i + arr[i]);

            // use the step : 
            // har move me ek step khatam ho jata hai : 
            steps--;

            // agar saare step khatam ho gaye 
            // to hame ek nayi jump leni hai : 
            if(steps == 0){
                jumps++;

                // cannot move further : 
                // mai is point se aage nahi ja sakta : 
                if(i >= max_reach){
                    return -1;
                }

                // update the step : 
                // mai itne aage or ja sakta hoon 
                steps = max_reach - i;
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
        int ans = minimum_jump(arr, n);
        System.out.println("minimum jump to reach the last = " + ans);
        
    }
}
