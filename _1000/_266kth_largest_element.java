package _1000;

import java.util.PriorityQueue;

public class _266kth_largest_element {
    public static int kth_largest(int arr[] , int n , int k){
        // use the min heap of size K : 
        // O(nlogK)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            if(pq.size() == k){

                // pop the smallest element 
                // and push the greater element : 
                if(arr[i] > pq.peek()){
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
