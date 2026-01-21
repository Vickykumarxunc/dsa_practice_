import java.util.Scanner;
import java.util.Stack;
public class _119valid_preorder_for_bst {
    public static boolean valid_preorder(int arr[] , int n){

        // create a stack : 
        Stack<Integer> st = new Stack<>();
        
        // hum ek minimum range maintain karege : 
        // jab hum right side me ja rahe hoge to hum kabhi bhi left me nahi jayege root ke 
        int min  = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){

            // jab hum right side me jaye ge to minimum(root) se agar koi choti value mili 
            // to vo correct preorder nahi hai: 
            if(arr[i] < min){
                return false;
            }

            // jab hum right side me ja rahe ho 
            // jab hum left seide se bahar aa rahe ho : 
            // to kiske right me ja rahe hai(root) ko minimum bana do : 
            while(!st.isEmpty() && arr[i] > st.peek()){
                min = st.pop();
            }
            // stack me left subtree ko hamesa push karo :
            st.push(arr[i]); 
        }
        // agar pura traverse ho gaya to preorder valid preorder hai : 
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the arrray : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the preorder of the bst : ");
        for(int i = 0;i<n; i++){
            arr[i] = sc.nextInt();
        }
        boolean ans = valid_preorder(arr, n);
        System.out.println("given array is valid preorder  = " + ans);

    }
}
