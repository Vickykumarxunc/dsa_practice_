package _1000;

public class _288sorted_array_to_bst {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node create(int arr[] , int low , int high){
        if(low > high){
            return null;
        }
        int mid = low + (high - low)/2;
        Node root = new Node(arr[mid]);

        root.left = create(arr , low , mid - 1);
        root.right = create(arr , mid + 1 , high);

        return root;
    }
    public static Node array_to_bst(int arr[]){
        return create(arr , 0 , arr.length - 1);
    }
    public static void main(String[] args) {
        
    }
}
