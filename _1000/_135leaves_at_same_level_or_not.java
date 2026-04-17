package _1000;

public class _135leaves_at_same_level_or_not {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static boolean leaves_at_same_level(Node root){
        int leaves_level[] = new int[]{0};
        return check(root , leaves_level , 1);
    }
    public static boolean check(Node root , int leaves_level[] , int level){
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            if(leaves_level[0] == 0){
                leaves_level[0] = level;
            }
            else{
                return leaves_level[0] == level;
            }
        }
        return check(root.left , leaves_level , level + 1) && check(root.right , leaves_level , level + 1);
    }
    public static void main(String[] args) {
        
    }
}
