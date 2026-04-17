package _1000;
import java.util.ArrayList;
public class _298validate_bst {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    // appraoch 1 
    // phle inorder nikal lo agar inorder sorted hai to valid bst hai varna nahi hai : 
    public static void inorder(Node root , ArrayList<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left , list);
        list.add(root.data);
        inorder(root.right , list);
    }
    public static boolean valid_bst1(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root , list);
        for(int i = 1; i<list.size(); i++){
            if(list.get(i) < list.get(i - 1)){
                return false;
            }
        }
        return true;
    }
    // approach  2 : 
    // main range pass karuga agar node range ke bahar hai to invalid bst hai : 
    public static boolean check(Node root , int min , int max){
        if(root == null){
            return true;
        }
        if(root.data <= min || root.data >= max){
            return false;
        }
        return check(root.left , min , root.data) && check(root.right , root.data , max);
    }
    public static boolean valid_bst2(Node root){
        return check(root , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }
    public static void main(String[] args) {
        
    }
}
