package _1000;

public class _112floor_in_bst {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int floor(Node root , int x){
        if(root == null){
            return -1;
        }
        int floor = -1;
        while(root != null){
            if(root.data <= x){
                floor = root.data;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return floor;
    }
  public static void main(String[] args) {
    
  }  
}
