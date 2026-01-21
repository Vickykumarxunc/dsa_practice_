
import java.util.Scanner;

public class _122LargestNumberPossible {

    public static String largestNumber(int n , int sum){

        // if number is not possible : 
        if(sum > n * 9){
            return "-1";
        }
        // if sum == 0 and n == 1 return 0 else return -1; 
        if(sum == 0){
            if(n == 1){
                return "0";
            }
            else{
                return "-1";
            }
        }
        // now we apply the greedy approach: 
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i<n; i++){

            // jab tak sum greater than or equal to 9 hai to ans me 9 add karte rahe left side me : 
            if(sum >= 9){
                ans.append(9);
                
                // decease the sum by 9 : 
                sum -= 9;
            }
            // agar sum 9 se chota ho jaye : 
            // to jo sum bacha use ans ke last me add kar do : 
            else{
                ans.append(sum);
                sum = 0;
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the sum : ");
        int sum = sc.nextInt();
        System.out.println("enter the digit : ");
        int n = sc.nextInt();

        String ans  = largestNumber(n, sum);
        System.out.println("largest number formed by the sum  = " + ans);
        
    }
}

//?Given two numbers n and s , find the largest number that can be formed with n digits and whose sum of digits should be equals to s. Return -1 if it is not possible.