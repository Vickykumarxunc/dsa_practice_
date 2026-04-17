package _1000;
import java.util.ArrayList;
import java.util.Stack;

public class _119iterative_postorder_using_2stack {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static ArrayList<Integer> postorder(Node root){
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        st1.push(root);
        while(!st1.isEmpty() || !st2.isEmpty()){
            Node temp = st1.pop();
            st2.push(temp);
            if(temp.left != null){
                st1.push(temp.left);
            }
            if(temp.right != null){
                st1.push(temp.right);
            }
        }
        while(!st2.isEmpty()){
            list.add(st2.pop().data);
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
