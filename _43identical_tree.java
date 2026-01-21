import java.util.*;

public class _43identical_tree {
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
    public static boolean isIdentical(Node root1 , Node root2){

        // base condition : 
        // agar dono tree null hai to null tree always identical hote hai : 
        if(root1 == null && root2 == null){
            return true;
        }
        // agar dono tree me se koi bhi ek tree null hai to return false : 
        if(root1 == null || root2 == null){
            return false;
        }
        // agar dono tree ki structure different hai ya node ka data different hai return false : 
        if(root1.data != root2.data){
            return false;
        }
        // check for the left subtree and right subtree : 
        return isIdentical(root1.left, root2.left) && isIdentical(root2.right, root2.right);
    }
    public static void main(String[] args) {
        String arr1[] = {"1" , "2" , "3" , "4" , " "};
        String arr2[] = {"1" , "2" , "3" , "4" , " "};

        Node root1 = createNode(arr1);
        Node root2 = createNode(arr2);

        boolean isIdentical = isIdentical(root1, root2);
        System.out.println("both tree is identical or not = " + isIdentical);
        
    }
}
