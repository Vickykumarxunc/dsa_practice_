import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _9left_view_of_binary_tree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node createNode(String arr[] , int n){
        
        int x = Integer.parseInt(arr[0]);
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(x);
        q.add(root);
        int i = 1;

        while(i < n - 1){
            Node left = new Node(-1);
            Node right = new Node(-1);
            Node temp = q.remove();
            if(" ".equals(arr[i])){
                left = null;
            }
            else{
                int l = Integer.parseInt(arr[i]);
                left.data = l;
                q.add(left);
            }
            if(" ".equals(arr[i + 1])){
                right = null;
            }
            else{
                int r = Integer.parseInt(arr[i + 1]);
                right.data = r;
                q.add(right);
            }
            temp.left = left;
            temp.right = right;
            i += 2;
        }
        return root;
    }
    public static void find(Node root , ArrayList<Integer> list , int level , int max[]){
        if(root == null){
            return;
        }
        // apply the prefix : 
        if(max[0] < level){
            max[0] = level;
            list.add(root.data);
        }
        // left call : 
        find(root.left , list , level + 1 , max);
        // right call : 
        find(root.right , list , level + 1 , max);
    }
    public static ArrayList<Integer> left_view(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        int max[] = new int[]{0};
        find(root , list , 1 , max);
        return list;
    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);

    }
    public static void main(String[] args) {
        String arr[] = {"1" , "2" , "3" , "4" , "5" , "6" , " "};
        Node root = createNode(arr, arr.length);
        ArrayList<Integer> ans = left_view(root);
        preorder(root);
        System.out.println();
        System.out.println(ans);

    }
}
