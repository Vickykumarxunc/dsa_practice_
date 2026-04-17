package _1000;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class _268top_k_frequent_element{
    public static ArrayList<Integer> topKFrequent(int arr[] , int k){
        int n = arr.length;

        // create a hashmap to store the frequency : 
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
        }
        // create a min heap store the value based on the ferquency : 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b)-> map.get(a) - map.get(b));
        for(int key : map.keySet()){
            pq.add(key);
            if(pq.size() > k){
                pq.poll();
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        return list;
    }
    public static void main(String args[]){

    }
}