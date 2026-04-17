package _1000;
public class _286subtree_of_another_tree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static boolean isIdentical(Node root1 , Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.data != root2.data){
            return false;
        }
        return isIdentical(root1.left , root2.left) || isIdentical(root1.right , root2.right);
    }
    public static boolean isSubtree(Node root , Node subTree){
        if(root == null){
            return false;
        }
        if(root.data == subTree.data){
            if(isIdentical(root , subTree)){
                return true;
            }
        }
        return isSubtree(root.left , subTree) || isSubtree(root.right , subTree);
    }
    public static void main(String args[]){

    }
}