
import java.util.HashSet;
import java.util.Scanner;

public class _19two_sum_pair_with_given_sum {
    public static boolean twoSum(int arr[] , int n , int target){

        // use the hashSet : 
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<n; i++){
            int diff = target - arr[i];
            if(set.contains(diff)){
                return true;
            }
            set.add(arr[i]);
        }
        return false;
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
        System.out.println("enter the target : ");
        int target = sc.nextInt();

        boolean ans = twoSum(arr, n, target);
        System.out.println(ans);
    }
}
