package _1000;
import java.util.Stack;

public class _113pair_sum_in_bst {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static boolean pair_sum(Node root , int target){
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        Node curr1 = root;
        Node curr2 = root;
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
                return false;
            }
            if(st1.peek() == st2.peek()){
                return false;
            }
            int sum = st1.peek().data + st2.peek().data;
            if(sum == target){
                return true;
            }
            else if(sum < target){
                curr1 = st1.pop().right;
            }
            else{
                curr2 = st2.pop().left;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
    }
}
