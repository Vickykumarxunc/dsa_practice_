package _1000;

import java.util.PriorityQueue;

public class _280sort_a_nearly_sorted_array {
    public static void nearlySorted(int arr[] , int n , int k){

        // isme hum ek min heap banayge k + 1 size ka 
        // first k + 1 array ke element ko heap me push karo : 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<=k; i++){
            pq.add(arr[i]);
        }
        // ab har window ka minimum element element hum instant find kar sakte hai with the help of heap 
        // current window ko minimum element lo usko uski original position par put karo : 
        // first window ko slide karo (means new element heap me add karo ,)
        int j = 0;
        for(int i = k + 1; i<n; i++){

            // remove min 
            arr[j++] = pq.remove();

            // add current element : 
            pq.add(arr[i]);
        }
        // ab jo heap me element bache hai use remove karo : 
        while(!pq.isEmpty()){
            arr[j++] = pq.poll();
        }
    }
    public static void main(String[] args) {
        
    }
}
/*
k smallest / largest
nearly sorted
top k
closest
frequency

➡️ Use Heap 
*/
