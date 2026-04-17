package _1000;
import java.util.Stack;
import java.util.ArrayList;

public class _110merge_two_bst {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static ArrayList<Integer> merge_two_bst(Node root1 , Node root2){
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        Node curr1 = root1;
        Node curr2 = root2;
        while(curr1 != null || curr2 != null || !st1.isEmpty() || !st2.isEmpty()){
            while(curr1 != null){
                st1.push(curr1);
                curr1 = curr1.left;
            }
            while(curr2 != null){
                st2.push(curr2);
                curr2 = curr2.left;
            }
            if(!st1.isEmpty() && !st2.isEmpty()){
                if(st1.peek().data <= st2.peek().data){
                    Node temp = st1.pop();
                    list.add(temp.data);
                    curr1 = temp.right;
                }
                else{
                    Node temp = st2.pop();
                    list.add(temp.data);
                    curr2 = temp.right;
                }
            }
            else if(!st1.isEmpty()){
                Node temp = st1.pop();
                list.add(temp.data);
                curr1 = temp.right;
            }
            else{
                Node temp = st2.pop();
                list.add(temp.data);
                curr2 = temp.right;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
