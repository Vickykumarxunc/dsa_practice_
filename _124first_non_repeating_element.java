import java.util.HashMap;
import java.util.Scanner;

public class _124first_non_repeating_element {
    public static int non_repeating(int arr[] , int n){

        // we use the hashMap
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] ,  0 ) + 1);
        }
        for(int i = 0; i<n; i++){
            if(map.get(arr[i]) == 1){
                return arr[i];
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        System.out.println("enter the array element  : ");
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = non_repeating(arr, n);
        System.out.println("first non repeating element in the array =  " + ans);
        

    }
}

/*
?Find the first non-repeating element in a given array arr of integers and if there is not present any non-repeating element then return 0

?Note: The array consists of only positive and negative integers and not zero.
 */
