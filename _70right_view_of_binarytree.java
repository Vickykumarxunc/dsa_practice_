import java.util.*;

public class _70right_view_of_binarytree {
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
        Node root = new Node(x);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        while(i < n - 1){
            Node left = new Node(-1);
            Node right = new Node(-1);
            Node temp = q.remove();
            
            if(arr[i].equals(" ")){
                left = null;
            }
            else{
                int l = Integer.parseInt(arr[i]);
                left.data = l;
                q.add(left);
            }
            if(arr[i + 1].equals(" ")){
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
    public static ArrayList<Integer> rightView(Node root){

        ArrayList<Integer> list = new ArrayList<>();

        // we use the reverse preorder : 
        int max[] = new int[]{0};

        find(root , list , max , 1);

        return list;
    }
    public static void find(Node root , ArrayList<Integer> list , int max[] , int level){

        if(root == null){
            return;
        }
        if(max[0] < level){
            list.add(root.data);
            max[0] = level;
        }
        find(root.right , list , max , level + 1);
        find(root.left , list , max , level + 1);
    }
    public static void main(String[] args) {
        String arr[] = {"1" , "2" , "3" , "4" , " " , " " , " " ," " , "5"};
        Node root = createNode(arr, arr.length);

        ArrayList<Integer> list = rightView(root);
        System.out.println(list);

    }
}
