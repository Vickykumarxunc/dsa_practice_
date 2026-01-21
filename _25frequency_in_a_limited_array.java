import java.util.*;
public class _25frequency_in_a_limited_array {
    public static ArrayList<Integer> frequencyCount(int arr[] , int n){

        // ek frequency array bana lo : 
        int freq[] = new int[n];

        // travese the array : 
        for(int i = 0; i<n; i++){
            freq[arr[i] - 1]++;
        }
        // ab frequency array ki value list ke ander fill kar do : 
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : freq){
            list.add(i);
        }
        //  return the list 
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

        ArrayList<Integer> ans = frequencyCount(arr, n);
        System.out.println(ans);
    }
}
/*
You are given an array arr[] containing positive integers. The elements in the array arr[] range from  1 to n (where n is the size of the array),
 and some numbers may be repeated or absent. Your have to count the frequency of all numbers in the range 1 to n and return an array of size n such that result[i]
  represents the frequency of the number i (1-based indexing).
 */
