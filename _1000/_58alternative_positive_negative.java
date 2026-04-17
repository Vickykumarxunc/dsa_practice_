package _1000;

import java.util.ArrayList;

public class _58alternative_positive_negative {
    public static ArrayList<Integer> rearrange(int arr[] , int n){
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(arr[i] >= 0){
                positive.add(arr[i]);
            }
            else{
                negative.add(arr[i]);
            }
        }
        int i = 0;
        int j = 0;
        while(i < positive.size() && j < negative.size()){
            ans.add(positive.get(i++));
            ans.add(negative.get(j++));
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
