package _1000;

import java.util.ArrayList;

public class _121morris_traversal_inorder {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static ArrayList<Integer> inorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        Node curr = root;
        while (curr != null) {
            if (curr.left == null) {
                list.add(curr.data);
                curr = curr.right;
            } else {
                Node pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    list.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
