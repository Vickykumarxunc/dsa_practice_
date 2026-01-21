import java.util.*;
public class _158winner_of_election {
    public static String[] winner(String arr[] , int n){

        // create a hashmap : 
        TreeMap<String , Integer> map = new TreeMap<>();
        for(int i = 0; i<n; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
        }
        String ans = "";
        int max_count = 0;
        
        // traverse the map : 
        for(String key : map.keySet()){

            if(map.get(key) >  max_count){
                ans = key;
                max_count = map.get(key);
            }
        }
        String result[] = {ans , "" + max_count};
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ente the size of the array : ");
        int n = sc.nextInt();
        String arr[] = new String[n];
        System.out.println("Enter the array element : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.next();
        }
        String ans[] = winner(arr, n);
        System.out.println("name = " + ans[0]);
        System.out.println("vote = " + ans[1]);

    }
}

/*
Given an array of n names arr of candidates in an election, where each name is a string of lowercase characters. A candidate name in the array represents a vote casted to the candidate. Print the name of the candidate that received the maximum count of votes. If there is a draw between two candidates, then print lexicographically smaller name.
 */
