package _1000;

import java.util.Collections;
import java.util.PriorityQueue;

public class _267kth_smallest_element {
    // O(nlogK)
    public static int kth_smallest(int arr[] , int n , int k){
        // use the max heap of size k : 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<n; i++){
            if(pq.size() == k){
                if(arr[i] < pq.peek()){
                    pq.poll();
                    pq.add(arr[i]);
                }
            }
            else{
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        
    }
}
