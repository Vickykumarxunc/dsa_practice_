package _1000;
import java.util.ArrayList;
import java.util.Stack;

public class _115common_in_two_bst {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static ArrayList<Integer> common_in_two_bst(Node root1 , Node root2){
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
            if(st1.isEmpty() || st2.isEmpty()){
                break;
            }
            if(st1.peek().data == st2.peek().data){
                list.add(st1.peek().data);
                curr1 = st1.pop().right;
                curr2 = st2.pop().right;
            }
            else if(st1.peek().data < st2.peek().data){
                curr1 = st1.pop().right;
            }
            else{
                curr2 = st2.pop().right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        
    }
}
