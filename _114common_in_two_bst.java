import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class _114common_in_two_bst {
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
    public static ArrayList<Integer> common(Node root1 , Node root2){
        ArrayList<Integer> list = new ArrayList<>();

        // create a two stack : 
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        // set the two pointer on the two tree : 
        Node curr1 = root1;
        Node curr2 = root2;

        // now traverse the both bst simultaneously inorder : 
        while((curr1 != null || !st1.isEmpty()) && (curr2 != null || !st2.isEmpty())){

            // push the left node of the both bst : 
            while(curr1 != null){
                st1.push(curr1);
                curr1 = curr1.left;
            }
            while(curr2 != null){
                st2.push(curr2);
                curr2 = curr2.left;
            }
            // now check the top of the stack element : 
            Node top1 = st1.peek();
            Node top2 = st2.peek();

            if(top1.data == top2.data){
                list.add(top1.data);

                // now pop the top of the stack : 
                st1.pop();
                st2.pop();

                // now move to the right side : 
                curr1 = top1.right;
                curr2 = top2.right;
            }
            else if(top1.data < top2.data){
                st1.pop();
                curr1 = top1.right;
            } 
            else{
                st2.pop();
                curr2 = top2.right;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        String arr1[] = {"5" , "3" , "7" , " "};
        String arr2[] = {"6" , "3" , "7" , " "};
        Node root1 = createNode(arr1);
        Node root2 = createNode(arr2);

        ArrayList<Integer> ans = common(root1, root2);
        System.out.println(ans);

    }
}
