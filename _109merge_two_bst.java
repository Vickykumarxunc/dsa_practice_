import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _109merge_two_bst {
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
    public static ArrayList<Integer> merge(Node root1 , Node root2){

        // create a array list jo ans store karege : 
        ArrayList<Integer> list = new ArrayList<>();

        // do stack banao jo bst ke element ko store karege : 
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        // ab dono bst ko simultaneously traverse karo : 
        while(root1 != null || root2 != null || !st1.isEmpty() || !st2.isEmpty()){

            // ab stack me root ke left node ko push karo : 
            while(root1 != null){
                st1.push(root1);
                root1 = root1.left; // left side me chalte jao : 
            }
            while(root2 != null){
                st2.push(root2);
                root2 = root2.left; // left side me chalte jao : 
            }

            // ab dono stack ke top ki value ko compare karege 
            /// jo value choti hogi use pop karege ans me add karege aur root ko uske right par place karege : 
            if(!st1.isEmpty() && !st2.isEmpty()){
                
                // dono stack ke top ki value ko compare karo 
                // aur choti value ko pop karo : 
                if(st1.peek().data <= st2.peek().data){
                    Node temp = st1.pop();
                    
                    // add into the and : 
                    list.add(temp.data);

                    // and goes to the right side : 
                    root1 = temp.right;
                }
                else{
                    // agar stack2 ko top ki choti value ho : 
                    Node temp = st2.pop();

                    // add into the ans : 
                    list.add(temp.data);

                    // goes to the right side : 
                    root2 = temp.right;
                }
            }
            // agar stack1 me element bache hai : 
            else if(!st1.isEmpty()){
                
                // pop the value : 
                Node temp = st1.pop();
                
                // add into the ans : 
                list.add(temp.data);

                // goes to the right side : 
                root1 = temp.right;
            }
            // agar stack2 me element bache ho : 
            else{
                
                // pop the smallest value : 
                Node temp = st2.pop();

                // add into the ans : 
                list.add(temp.data);

                // goes to the right side : 
                root2 = temp.right;

            }
        }
        return list;
    }
    public static void main(String[] args) {
        String arr1[] = {"3" ,"1" , "5" , " "};
        String arr2[] = {"4" , "2" , "6" , " "};

        Node root1 = createNode(arr1);
        Node root2 = createNode(arr2);

        ArrayList<Integer> ans = merge(root1, root2);
        System.out.println(ans);

    }
}
