package _1000;

public class _125construct_bst_from_post_order {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node construct_bst(int postorder[] , int n){
        int idx[] = new int[]{n - 1};
        return create(postorder , idx , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }
    public static Node create(int postorder[] , int idx[] , int min , int max){
        if(idx[0] < 0){
            return null;
        }
        int value = postorder[idx[0]];
        idx[0]--;
        
        if(value < min || value > max){
            return null;
        }
        Node root = new Node(value);

        root.right = create(postorder , idx , value , max);
        root.left = create(postorder , idx , min , value);
         
        return root;
    }
    public static void main(String[] args) {
        
    }
}
