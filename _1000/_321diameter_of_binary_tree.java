package _1000;

public class _321diameter_of_binary_tree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int height(Node root , int diameter[]){

        // base case : 
        if(root == null){
            return 0;
        }
        // har ek node ke liye left height and right height nikalo 
        // aur maximum diameter maintain karo : 
        int left = height(root.left , diameter);
        int right = height(root.right , diameter);

        diameter[0] = Math.max(diameter[0] , left + right);

        return 1 + Math.max(left , right);
    }
    public static int diameter(Node root){
        
        int diameter[] = new int[]{0};
        height(root , diameter);
        return diameter[0];
    }
    public static void main(String[] args) {
        
    }
}
