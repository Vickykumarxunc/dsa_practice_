package _1000;
import java.util.ArrayList;

public class _294_binary_tree_path_sum {
    public static class Node{
        int data;
        Node left;
        Node right;
    }
    // for binary tree curr = (curr << 1) | root.val;

    public static void find(Node root , ArrayList<Integer> list , int sum){
        if(root == null){
            return;
        }
        sum += root.data;
        if(root.left == null && root.right == null){
            list.add(sum);
            return;
        }
        find(root.left , list , sum);
        find(root.right , list , sum);
    }
    public static ArrayList<Integer> root_to_leaf_path(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        find(root , list , 0);
        return list;
    }
    public static void main(String args[]){

    }
}
