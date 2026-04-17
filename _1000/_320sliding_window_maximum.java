package _1000;

import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayList;

public class _320sliding_window_maximum {
    // time = O(N)
    // space = O(K)
     public static ArrayList<Integer> sliding_window_maximum(int arr[] , int n , int k){

        Deque<Integer> dq = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        // hame har ek element ke liye 4 kaam karne hai : 
        for(int i = 0; i<n; i++){

            // step1 : remove out of window element from the front : 
            if(!dq.isEmpty() && dq.getFirst() <= i - k){
                dq.removeFirst();
            }
            // step2 : hum dequeu ke ander sirf unhi element ka index rakhege ko aage jake maximum ban sakte hai :
            // means hum jo element current element se chote hai unhe remove kar de ge : 
            while(!dq.isEmpty() && arr[i] > arr[dq.getLast()]){
                dq.removeLast();
            }
            // step3 : current element ka index dequeu ke last me add kar do : 
            dq.addLast(i);

            // step4 : agar window complete ho gayi 
            // to current window ka maximum element dequeue ke front par hoga : 
            if(i >= k - 1){
                list.add(arr[dq.getFirst()]);
            }
        }
        return list;
     }
    public static void main(String args[]){

    }
}
