package _1000;

public class _152search_node_in_bst {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static boolean search_node_iterative(Node root , int key){
        if(root == null){
            return false;
        }
        while(root != null){
            if(root.data == key){
                return true;
            }
            else if(root.data < key){
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return false;
    }
    public static boolean search_Node_recursive(Node root , int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        else if(root.data < key){
            return search_Node_recursive(root.right, key);
        }
        else{
            return search_Node_recursive(root.left, key);
        }
    }
    public static void main(String[] args) {
        
    }
}
