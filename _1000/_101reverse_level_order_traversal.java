package _1000;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;


public class _101reverse_level_order_traversal {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static ArrayList<Integer> traverse(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<Node> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        q.add(root);
        
        while(!q.isEmpty()){
            Node temp = q.remove();
            st.push(temp.data);
            if(temp.right != null){
                q.add(temp.right);
            }
            if(temp.left != null){
                q.add(temp.left);
            }
        }
        while(!st.isEmpty()){
            list.add(st.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        
    }
}
