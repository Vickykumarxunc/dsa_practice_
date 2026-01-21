import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
public class _112pair_sum_inbst {
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
    public static void inorder(Node root , ArrayList<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left , list);
        list.add(root.data);
        inorder(root.right , list);
    }
    public static boolean pair_sum(Node root , int target){

        // create a array list which store the inorder traversal : 
        ArrayList<Integer> list = new ArrayList<>();
        
        // apply the inorder : 
        inorder(root , list);

        // now apply the two pointer apporach on the list : 
        int left = 0;
        int right = list.size() - 1;

        // traverse the list : 
        while(left < right){

            int sum = list.get(left) + list.get(right);
            
            if(sum == target){
                return true;
            }
            else if(sum < target){
                left++;
            }
            else{
                right--;
            }
        }
        return false;
    }
    // using the hash Set : 
    public static boolean pair_sum_using_set(Node root , int target){
        HashSet<Integer> set = new HashSet<>();
        // now apply the preorder recursively : 
        return preorder(root , target , set);
    }
    public static boolean preorder(Node root , int target , HashSet<Integer> set){

        // agar root null ho to return false : 
        if(root == null){
            return false;
        }
        // go to the left side : 
        if(preorder(root.left, target, set)){
            return true;
        }
        // check karo set ke ander pair element present hai ya nahi : 
        int diff = target - root.data;
        if(set.contains(diff)){
            return true;
        }
        // go to the right side : 
        return preorder(root.right , target , set);
    }
    public static void main(String[] args) {
        String arr[] = {"15" , "10" , "20" , "8" , "12" , "16" , "25" , " "};
        Node root = createNode(arr);
        int target = 35;
        boolean ans = pair_sum(root, target);
        System.out.println("sum present in the bst or not = " + ans);
        
    }
}
