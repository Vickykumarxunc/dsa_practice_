package _1000;

public class _81kth_largest_smallest_in_bst {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int kth_largest(Node root , int k){
        int count[] = new int[]{0};
        int max[] = new int[]{0};
        find_largest(root , count , max , k);
        return max[0];
    }
    public static void find_largest(Node root , int count[] , int max[] , int k){
        if(root == null || count[0] >= k){
            return;
        }
        find_largest(root.right , count , max , k);
        count[0]++;
        if(count[0] == k){
            max[0] = root.data;
            return;
        }
        find_largest(root.left , count , max , k);
    }
    public static int kth_smallest(Node root , int k){
        int count[] = new int[]{0};
        int min[] = new int[]{0};
        find_smallest(root , count , min , k);
        return min[0];
    }
    public static void find_smallest(Node root , int count[] , int min[] , int k){
        if(root == null || count[0] >= k){
            return;
        }
        find_smallest(root.left , count , min , k);
        count[0]++;
        if(count[0] == k){
            min[0] = root.data;
            return;
        }
        find_smallest(root.right , count , min , k);
    }
    public static void main(String[] args) {
        
    }
}
