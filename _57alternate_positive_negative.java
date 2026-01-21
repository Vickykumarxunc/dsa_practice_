import java.util.ArrayList;
import java.util.Scanner;

public class _57alternate_positive_negative {

    public static ArrayList<Integer> rearrange(int arr[] , int n){

        // positive negative element ko seperate store kar lo : 
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        for(int i = 0; i<n; i++){
            if(arr[i] >= 0){
                positive.add(arr[i]);
            }
            else if(arr[i] < 0){
                negative.add(arr[i]);
            }
        }
        // now rearrange it : 
        int i = 0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(i < positive.size() && j < negative.size()){
            ans.add(positive.get(i++));
            ans.add(negative.get(j++));
        }
        // now add the remaining element : 
        while(i < positive.size()){
            ans.add(positive.get(i++));
        }
        while(j < negative.size()){
            ans.add(negative.get(j++));
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        int arr1[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr1[i] = sc.nextInt();
        }
    }
}
/*
Given an unsorted array arr containing both positive and negative numbers. Your task is to rearrange the array and convert it into an array of alternate positive and negative numbers without changing the relative order.
 */
