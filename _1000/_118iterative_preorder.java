package _1000;
import java.util.ArrayList;
import java.util.Stack;

public class _118iterative_preorder {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static ArrayList<Integer> preorder(Node root){
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        st.push(root);
        while(st.isEmpty()){
            Node temp = st.pop();
            list.add(temp.data);
            if(temp.right != null){
                st.add(temp.right);
            }
            if(temp.left != null){
                st.add(temp.left);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
