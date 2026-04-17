package _1000;

public class _124construct_bst_from_preorder {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node construct_bst(int preorder[] , int n){
        int idx[] = new int[]{0};
        return create(preorder , idx , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }
    public static Node create(int preorder[] , int idx[] , int min , int max){
        if(idx[0] >= preorder.length){
            return null;
        }
        int value = preorder[idx[0]];
        if(value < min || value > max){
            return null;
        }
        Node root = new Node(value);
        idx[0]++;
        
        root.left = create(preorder , idx , min , value);
        root.right = create(preorder , idx , value , max);
        return root;

    }
    public static void main(String[] args) {
        
    }
}
