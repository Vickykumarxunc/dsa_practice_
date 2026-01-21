public class _118construct_bst_from_postorder {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node postorder(int postorder[] , int n){

        // ek index array banao ek size ka jo as a global varaible ki trh kaam karege : 
        int index[] = new int[]{0};

        // post order ke liye hum array ko reverse order me traverse karege : 
        // kyoki postorder ka last element always root hota hai : 

        // recursion apply karo har ek node ke liye ek range pass karo min , max : 
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        Node root = create(postorder , index , min , max);
        return root;
    }
    public static Node create(int postorder[] , int index[] , int min , int max){

        // base condition : 
        if(index[0] < 0 || postorder[index[0]] < min || postorder[index[0]] > max){
            return null;
        }
        Node root = new Node(postorder[index[0]]);
        index[0]--;

        root.right = create(postorder , index , root.data , max);
        root.left = create(postorder , index , min , root.data);

        return root;
    }
    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    public static void main(String[] args) {
        int postorder[] = {1 , 7 , 5 , 50 , 40 , 10};
        Node root = postorder(postorder, postorder.length);
        postorder(root);
    }
}
