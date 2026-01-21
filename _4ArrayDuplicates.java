import java.util.*;
public class _4ArrayDuplicates {

    public static ArrayList<Integer> findDuplicates(int arr[] , int n){

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i<n; i++){

            // find the index : 
            int index = Math.abs(arr[i] - 1);

            // agar element phle se hi negative hai index par 
            // matlb current element ko mai dobara se visit kar raha hoon . 
            if(arr[index] < 0){
                list.add(Math.abs(arr[i]));
            }
            else{
                // marks as visited : 
                arr[index] = -1 * arr[index];
            }
        }
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
        ArrayList<Integer> list = findDuplicates(arr, n);
        System.out.println(list);
    }
}
/*
Given an array arr[] of size n, containing elements from the range 1 to n, and each element appears at most twice, return an array of all the integers that appears twice.

Note: You can return the elements in any order but the driver code will print them in sorted order.

Input: arr[] = [2, 3, 1, 2, 3]
Output: [2, 3] 
Explanation: 2 and 3 occur more than once in the given array.

 */
