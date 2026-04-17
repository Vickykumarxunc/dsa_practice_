package _1000;
import java.util.ArrayList;
import java.util.Stack;

public class _117iterative_inorder {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static ArrayList<Integer> inorder(Node root){
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        Node curr = root;
        while(curr != null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            Node temp = st.pop();
            list.add(temp.data);
            curr = temp.right;
            
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
