
import java.util.Scanner;

public class _1missing_element_in_array{
    public static int missing(int arr[] , int n){

        // sabse phle to total sum nikal lo : 
        int m = n + 1;
        int total_sum = (m * (m + 1))/2;

        // ab array ke har element ko total sum me se decrease do
        for(int i = 0; i<n; i++){
            total_sum -= arr[i];
        }
        // jo last ke sum bach jayega vo missing element hoga : 
        int missing_element = total_sum;
        return missing_element;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int missing_element = missing(arr , n);
        System.out.println("missing element in the array = " + missing_element);

    }
}

/*
You are given an array arr[] of size n - 1 that contains distinct integers in the range from 1 to n (inclusive).
This array represents a permutation of the integers from 1 to n with one element missing.
 Your task is to identify and return the missing element.

Input: arr[] = [8, 2, 4, 5, 3, 7, 1]
Output: 6
Explanation: All the numbers from 1 to 8 are present except 6.
 */