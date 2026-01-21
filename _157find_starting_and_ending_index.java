import java.util.ArrayList;
import java.util.Scanner;
public class _157find_starting_and_ending_index {
    public static ArrayList<Integer> findIndex(int arr[] , int n , int key){

        ArrayList<Integer> list = new ArrayList<>();
        int first_index = -1;
        int last_index = -1;
        for(int i = 0; i<n; i++){

            if(arr[i] == key){
                if(first_index == -1){
                    first_index = i;
                }
                last_index = i;
            }
        }
        list.add(first_index);
        list.add(last_index);
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        System.out.println("enter the array element : ");
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the target : ");
        int target = sc.nextInt();
        ArrayList<Integer> ans = findIndex(arr, n, target);
        System.out.println(ans);
    }
}

/*
Given an unsorted array arr[] of integers and a key which is present in this array. You need to write a program to find the start index( index where the element is first found from left in the array ) and end index( index where the element is first found from right in the array ) return an array of length 2 with elements start index and end index.(0 based indexing is used)

If the key does not exist in the array then return -1 for both start and end index in this case
 */