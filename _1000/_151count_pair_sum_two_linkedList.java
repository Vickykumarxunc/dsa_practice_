package _1000;

import java.util.HashSet;

public class _151count_pair_sum_two_linkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static int count_Pair(Node head1 , Node head2 , int target){
        HashSet<Integer> set = new HashSet<>();
        Node temp = head1;
        while(temp != null){
            set.add(temp.data);
        }
        temp = head2;
        int count = 0;
        while(temp != null){
            if(set.contains(target - temp.data)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}