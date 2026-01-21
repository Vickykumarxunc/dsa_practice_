
import java.util.Scanner;

public class _31square_root {
    public static int find(int n){
        
        // we apply the binary search : 
        int low = 1;
        int high = n;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            int square = mid * mid;
            if(square == n){
                return mid;
            }
            else if(square < n){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number : ");
        int n = sc.nextInt();

        int ans = find(n);
        System.out.println("square root of the number or near the square root = " + ans);
    }
}

/*
Given a positive integer n, find the square root of n. If n is not a perfect square, then return the floor value.

Floor value of any number is the greatest Integer which is less than or equal to that numbe
 */
