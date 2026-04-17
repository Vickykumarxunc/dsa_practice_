package _1000;
import java.util.ArrayList;
import java.util.Stack;
public class _56level_order_traversal_in_spiral_form {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static ArrayList<Integer> traversal(Node root){
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        st1.push(root);
        while(!st1.isEmpty() || !st2.isEmpty()){
             
            while(!st1.isEmpty()){
                Node temp = st1.pop();
                list.add(temp.data);
                if(temp.right != null){
                    st2.add(temp.right);
                }
                if(temp.left != null){
                    st2.add(temp.left);
                }
            }
            while(!st2.isEmpty()){
                Node temp = st2.pop();
                list.add(temp.data);
                if(temp.left != null){
                    st1.push(temp.left);
                }
                if(temp.right != null){
                    st1.push(temp.right);
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
