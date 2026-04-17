package _1000;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class _324first_negative_element_of_every_window {
    // time = O(n)
    // space = O(k)
    public static ArrayList<Integer> first_negative_element_of_every_window(int arr[] , int n , int k){
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i<n; i++){

            // step 1 : remove out of window element : 
            if(q.peek() <= i - k){
                q.poll();
            }
            // step 2 : add negative element : 
            if(arr[i] < 0){
                q.add(i);
            }
            // step 3 : window is complete : 
            if(i >= k - 1){
                if(!q.isEmpty()){
                    list.add(arr[q.peek()]);
                }
                else{
                    list.add(0);
                }
            }
        }
         return list;
    }
    public static void main(String[] args) {
        
    }
}
