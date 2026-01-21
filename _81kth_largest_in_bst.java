import java.util.LinkedList;
import java.util.Queue;

public class _81kth_largest_in_bst {
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
            if(arr[i + 1].equals( " ")){
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

    // kth largest element in the bst : : : 
    public static int kthLargest(Node root , int k){

        int kLargest[] = new int[]{Integer.MIN_VALUE};
        int count[] = new int[]{0};

        reverseInorder(root , count , kLargest , k);
        return kLargest[0];
    }
    public static void reverseInorder(Node root , int count[] , int kLargest[] , int k){

        if(root == null || count[0] >= k){
            return;
        }
        // phle right most chale jao tree : 
        reverseInorder(root.right , count , kLargest , k);

        // increase the counter after visiting right subtree : 
        count[0]++;

        // check if the current node is the largest Node : 
        if(count[0] == k){
            kLargest[0] = root.data;
            return;
        }
        // traverse the left subtree if kth largest is not found : 
        reverseInorder(root.left, count, kLargest, k);

    }

    // kth smallest element in the bst :: : : 
    public static int kthSmallest(Node root , int k){

        int ksmallest[] = new int[]{Integer.MAX_VALUE};
        int count[] = new int[]{0};
        inorder(root , count , ksmallest , k);
        return ksmallest[0];
    }
    public static void inorder(Node root , int count[] , int ksmallest[] , int k){
        
        // base condition : 
        if(root == null ||  count[0] >= k){
            return;
        }
        // go to the left side : 
        inorder(root.left , count , ksmallest , k);
        count[0]++;

        // now apply the conditon : 
        if(count[0] == k){
            ksmallest[0] = root.data;
            return;
        }
        // go to the right side : 
        inorder(root.right , count , ksmallest , k);
    }

    public static void main(String[] args) {
        String arr[] = {"4" , "2" , "9" , " "};
        Node root = createNode(arr);
        int k = 2;

        int largest = kthLargest(root, k);
        System.out.println(largest);

        int small = kthSmallest(root, k);
        System.out.println(small);
        
    }
}
