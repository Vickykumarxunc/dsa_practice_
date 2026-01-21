
import java.util.Scanner;

public class _40Longest_common_prefix_of_string {
    public static String commonPrefix(String arr[] , int n){

        String ans = arr[0];
        for(int i = 1; i<n; i++){
            ans = compare(ans , arr[i]);
            if(ans.equals("")){
                break;
            }
        }
        return ans;
    }
    public static String compare(String s1 , String s2){
        String result = "";
        int i = 0;
        int j = 0;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                result += s1.charAt(i);
            }
            else{
                break; // for the mismatch : 
            }
            i++;
            j++;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the no of string : ");
        String arr[] = new String[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextLine();
        }

        String ans = commonPrefix(arr, n);
        System.out.println(ans);
    }
}
