import java.util.*;
public class _8missing_and_repeating_element {
    public static ArrayList<Integer> find(int arr[] , int n){

        int missing = -1;
        int repeating = -1;

        // first find the repeating element by using the negative marking : 
        for(int i = 0; i<n; i++){

            // find the index : 
            int index = Math.abs(arr[i]) - 1;

            // agar index ki value phle se negative hai matlab maine current element ko dobara
            // se visit kiya hai to ye duplicate element hai . 
            if(arr[index] < 0){
                repeating = Math.abs(arr[i]);
            }
            // agar positive hai to use negative bana do : 
            else{
                arr[index] = -1 * arr[index];
            }
        }
        // now find the missing element : 
        // agar positive element hai to vo missing element hai : 
        for(int i = 0; i<n; i++){
            if(arr[i] > 0){
                missing = i + 1;
                break;
            }
        }
        // put the ans in the list : 
        ArrayList<Integer> list = new ArrayList<>();
        list.add(missing);
        list.add(repeating);

        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = find(arr, n);
        System.out.println(ans);
    }
}
/*
Given an unsorted array arr[] of size n, containing elements from the range 1 to n, it is known that one number in this range is missing, and another number occurs twice in the array, 
find both the duplicate number and the missing number.

Input: arr[] = [4, 3, 6, 2, 1, 1]
Output: [1, 5]
Explanation: Repeating number is 1 and the missing number is 5
 */
