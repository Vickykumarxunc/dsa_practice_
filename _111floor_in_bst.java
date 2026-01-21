import java.util.LinkedList;
import java.util.Queue;

public class _111floor_in_bst {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node createNode(String arr[]){
        int n = arr.length;
        int x = Integer.parseInt(arr[0]);
        Node root = new Node(x);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        while(i < n  - 1){
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
    public static int findFloor(Node root , int x){

        int ans = -1;
        while(root != null){

            if(root.data <= x){
                ans = root.data;
                root = root.right; // auke or nearest but less than x goes to right side : 
            }
            else{
                // agar value x se badi hai to left side me jao : 
                root = root.left;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String arr[] = {"5" , "1" , "7" , " " , "2" , " " , " " , " " , "3" , " "};
        Node root = createNode(arr);
        int x = 6;

        int ans = findFloor(root, x);
        System.out.println("floor value of x = " + ans);
        

    }
}
