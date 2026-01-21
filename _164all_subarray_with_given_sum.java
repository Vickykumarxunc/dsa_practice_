import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class _164all_subarray_with_given_sum {
    public static ArrayList<ArrayList<Integer>> all_subarray(int arr[] , int target, int n){

        // here we use the prefix sum and hashmap to handle the negatice cases : 
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();

        // intialize the hashMap : 
        map.put(0 , new ArrayList<>());
        map.get(0).add(-1);
        
        int curr_sum = 0;

        // traverse the array : 
        for(int i = 0; i<n; i++){

            // calculate the current sum: : (prefix sum )
            curr_sum += arr[i];

            // agar (curr_sum - target) map me present hai
            // aur ye mulitple time aa sakta hai  
            // har occurances ek vaild subarray banayegi :  
            if(map.containsKey(curr_sum - target)){

                // create a subarray : 
                for(int index : map.get(curr_sum - target)){

                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(index + 2);
                    temp.add(i + 1);
                    list.add(temp);
                }
            }
            // agar present nahi hai : 
            if(!map.containsKey(curr_sum)){
                map.put(curr_sum , new ArrayList<>());
                map.get(curr_sum).add(i);
            }
        }
        return list;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the target : ");
        int target = sc.nextInt();
        ArrayList<ArrayList<Integer>> ans = all_subarray(arr, target, n);
        System.out.println(ans);
    }
}
