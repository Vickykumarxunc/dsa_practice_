import java.util.LinkedList;
import java.util.Queue;

public class _110find_ceil_in_bst {
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
    public static int findCeil(Node root , int x){

        // we use the iterative appoach : 
        int ans = -1;

        // now traverse the root : 
        while(root != null){

            // agar current root ki value grater than hai x se 
            // to ye possible ans ho sakta hai : 
            if(root.data >= x){

                // to apane ans ko update kar do : 
                ans = root.data;

                // ab mai or nearest largest element ko find karne ki kosis karuga :
                // jo root ke left me present hoga : 
                root = root.left;
            }
            else{
                // agar root ki value choti hai x se 
                // to root ke right side jao : 
                root = root.right;
            }
        }
        
        return ans; // agar ceil value present karti ho : 
    }
    public static void main(String[] args) {
        String arr[] = {"5" , "1" , "7" , " " , "2" , " " , " " , " " , "3" , " "};
        Node root = createNode(arr);
        int x = 6;

        int ans = findCeil(root, x);
        System.out.println("ceil value of x is = " +  ans);


    }
}
