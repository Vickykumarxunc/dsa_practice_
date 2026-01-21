import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _115iterative_inorder_preorder_post_order {
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
    public static ArrayList<Integer> inorder(Node root){
        
        // jab tak root ka left mil ra stack me push karte chale jao : 
        // jao left null ho jaye to stack me se top ko pop karke uske right me chale jao :
        ArrayList<Integer> list = new ArrayList<>(); 
        Stack<Node> st = new Stack<>();
        Node curr = root;

        while(curr != null || !st.isEmpty()){

            // push all the left node : 
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            // pop the node from the stack and visit it : 
            Node top = st.pop();
            list.add(top.data);

            // goes to right side of the top node : 
            curr = top.right;
        }
        return list;
    }
    public static ArrayList<Integer> preorder(Node root){

        ArrayList<Integer> list = new ArrayList<>();

         // stack me root dalo -> pop karo -> visit karo -> right dalo -> left dalo . 
        Stack<Node> st = new Stack<>();
        
        while(!st.isEmpty()){
            Node curr = st.pop();
            list.add(curr.data);

            // push the right first : 
            if(curr.right != null){
                st.push(curr.right);
            }
            // push the left second : 
            if(curr.left != null){
                st.push(curr.left);
            }
        }
        return list;
    }
    public static ArrayList<Integer> postorder_using_2Stack(Node root){

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        // 1. stack st1 me root ko push karo : 
        st1.push(root);

        while(!st1.isEmpty()){

            // stack st1 se pop : 
            //us node ko stack st2 me push kar do 
            // left child ko st1 me push kar do : 
            // right child ko st2 me push kar do : 
            Node curr = st1.pop();
            st2.push(curr);

            if(curr.left != null){
                st1.push(curr.left);
            }
            if(curr.right != null){
                st1.push(curr.right);
            }
        }
        // agar st1 empty ho jaye : 
        while(!st2.isEmpty()){
            list.add(st2.pop().data);
        }
        return list;
    }
    public static ArrayList<Integer> post_order_using_1_stack(Node root){

        // hum ek stack use karte hai aur lastVisited Node yaad rakhte hai : 
        // agar right subtree visited nahi hua hai to right jao : 
        // warna node ko process karo aur lastvisited node ko update karo : 

        Stack<Node> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        Node curr = root;
        Node last_visited = null;

        while(curr != null && !st.isEmpty()){

            // phle left chain ko push kar do : 
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            // agar right child exist karta hai aur vo visited nahi hua : 
            Node peek = st.peek();
            if(peek.right != null && peek.right != last_visited){
                
                // then visited it : 
                curr = peek.right;
            }
            // agar vo visited ho gaya ho : 
            else{
                // to node ko process karo aur lastvisited node ko update karo : 
                list.add(peek.data);
                last_visited = st.pop();
            }
        }
        return list;
    }
    public static void main(String[] args) {
        String arr[] = {"50" , "30" , "70" , "20" , "40" , "60" , "80" , " " , "25" , " " , " " , "55" , "65" , " " , " "};
        Node root = createNode(arr);
    }
}
