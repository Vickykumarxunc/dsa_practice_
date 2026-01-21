import java.util.ArrayList;
import java.util.Scanner;

public class _34remove_duplicate_sorted_array {
    public static ArrayList<Integer> remove(int arr[] , int n){

        // take two pointer :
        int j = 0;
        for(int i = 1; i<n; i++){
            if(arr[i] != arr[i - 1]){

                // first increase the j : 
                // then put the current value on the j index : 
                arr[++j] = arr[i];
            } 
        }
        // create a array list of the unique element : 
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<=j; i++){
            list.add(arr[i]);
        }
        return list; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        System.out.println("enter the array element ; ");
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        } 
        ArrayList<Integer> ans = remove(arr, n);
        System.out.println(ans);
    }
}
