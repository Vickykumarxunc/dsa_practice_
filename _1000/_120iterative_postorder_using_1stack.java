package _1000;
import java.util.ArrayList;
import java.util.Stack;

public class _120iterative_postorder_using_1stack {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static ArrayList<Integer> postorder(Node root){
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        Node lastvisited = null;

        while(root != null || !st.isEmpty()){
            
            while(root != null){
                st.push(root);
                root = root.left;
            }
            Node curr = st.peek();
            if(curr.right != null && curr.right != lastvisited){
                root = curr.right;
            }
            else{
                list.add(curr.data);
                lastvisited = st.pop();
            }
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
