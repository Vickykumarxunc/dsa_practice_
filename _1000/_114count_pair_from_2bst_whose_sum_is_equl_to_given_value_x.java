package _1000;
import java.util.Stack;

public class _114count_pair_from_2bst_whose_sum_is_equl_to_given_value_x {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int count(Node root1 , Node root2 , int target){
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        Node curr1 = root1;
        Node curr2 = root2;
        int count = 0;
        while(curr1 != null || curr2 != null || !st1.isEmpty() || !st2.isEmpty()){
            while(curr1 != null){
                st1.push(curr1);
                curr1 = curr1.left;
            }
            while(curr2 != null){
                st2.push(curr2);
                curr2 = curr2.right;
            }
            if(st1.isEmpty() || st2.isEmpty()){
                break;
            }
            int sum = st1.peek().data + st2.peek().data;
            if(sum == target){
                count++;
                curr1 = st1.pop().right;
                curr2 = st2.pop().left;
            }
            else if(sum < target){
                curr1 = st1.pop().right;
            }
            else{
                curr2 = st2.pop().left;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}
