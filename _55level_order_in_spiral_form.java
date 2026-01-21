
import java.util.*;
import java.util.Stack;

public class _55level_order_in_spiral_form {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node createNode(String arr[] ,int n){
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
    public static ArrayList<Integer> findSpiral(Node root){
        
        ArrayList<Integer> list = new ArrayList<>();
        
        // base condition : agar tree empty hai to empty list return kar do :  
        if(root == null){
            return list;
        }
        // create a two stack : 
        // st1 -> left to right ka level store karege : 
        // st2 -> right to left ka level store karega : 
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        // starting me root ko st1 me dalte hai ; 
        st1.add(root);

        // jab tak dono me se koi ek stack empty na ho : 
        while(!st1.isEmpty() || !st2.isEmpty()){

            // st1 wale level ko process karo (left to right )
            while(!st1.isEmpty()){
                Node temp = st1.pop();

                // current node ko add karo 
                list.add(temp.data);

                // next level ke liye nodes ko st2 me right to left order me dalo : 
                if(temp.right != null){
                    st2.push(temp.right);
                }
                if(temp.left != null){
                    st2.push(temp.left);
                }
            }
            // st2 wale level ko process karo (right to left)
            while(!st2.isEmpty()){
                Node temp = st2.pop();

                // current node ka data add karo list me 
                list.add(temp.data);

                // next level ke nodes st1 me left to right order me daalo : 
                if(temp.left != null){
                    st1.push(temp.left);
                }
                if(temp.right != null){
                    st1.push(temp.right);
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        String arr[] = {"10" , "20" , "30" , "40" , "60" , " "};
        Node root = createNode(arr, arr.length);
        ArrayList<Integer> ans = findSpiral(root);
        System.out.println(ans);


    }
}
