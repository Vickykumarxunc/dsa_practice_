import java.util.Scanner;
import java.util.Stack;
public class _120valid_post_order_for_bst {
    public static boolean valid_post_order(int arr[] , int n){

        Stack<Integer> st = new Stack<>();

        // agar hum tree me ek baar left side me chale gaye to fir kabhi right me nahi jayege : 
        int max = Integer.MAX_VALUE;

        for(int i = n - 1; i >= 0; i--){

            // agar current value max se bhi badi hai
            // to hum dobara se right side me ja rahe hai 
            // to ye invalid post order hai : 
            if(arr[i] > max){
                return false;
            }
            // agar hum left side me ja rahe hai to maximum ko apane update kar de ge : 
            // jab hum right side se bahar aa rahe ho : 
            while(!st.isEmpty() && arr[i] < st.peek()){
                max = st.pop();
            }
            // right tree ko hamesa push karo stack ke ander :
            st.push(arr[i]); 
        }
        // agar traversal pura ho gaya ho to : 
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array :");
        int n = sc.nextInt();
        int postorder[] = new int[n];
        System.out.println("enter the postorder :");
        for(int i = 0; i<n; i++){
            postorder[i] = sc.nextInt();
        }
        boolean ans = valid_post_order(postorder, n);
        System.out.println("valid postorder or not  = " + ans);
    }
}
