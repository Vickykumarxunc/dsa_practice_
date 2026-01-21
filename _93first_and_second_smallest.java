import java.util.ArrayList;
import java.util.Scanner;

public class _93first_and_second_smallest {
    public static ArrayList<Integer> smallest(int arr[] , int n){

        int min1 = Integer.MAX_VALUE;
        int min2 = min1;

        for(int i = 0; i<n; i++){
            if(arr[i] < min1){
                min2 = min1;
                min1 = arr[i];
            }
            else if(arr[i] < min2 && arr[i]!= min1){
                min2 = arr[i];
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if(min1 == Integer.MAX_VALUE || min2 == Integer.MAX_VALUE){
            ans.add(-1);
            return ans;
        }
        ans.add(min1);
        ans.add(min2);

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = smallest(arr , n);
        System.out.println(ans);


    }
}
