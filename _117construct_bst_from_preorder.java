public class _117construct_bst_from_preorder {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node create_bst(int preorder[] , int n){

        // create a index array of size one 
        // jo as a global variable ki trh treat karega 
        // isko hum preorder me se element ko aceess karne ke liye use karege : 
        int index[] = new int[]{0};

        // ab hum har node ke liye ek range pass karege inside the recursion function :
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

       Node root =  create(preorder , index , min , max);
       return root;
    }
    public static Node create(int preorder[] , int index[] , int min , int max){

        // meri base codition kya hogi : 
        // 1. agar preorder array pur traveseho gaya ho (index == n)
        // 2. agar current index ka element apani min max ki range me na ho 
        // tab hum null return kar de ge : 
        if(index[0] == preorder.length || preorder[index[0]] < min || preorder[index[0]] > max){
            return null;
        }
        // ab jo preorder ka first element hota hai vo hamesa root node hota hai : 
        Node root = new Node(preorder[index[0]]);
        index[0]++; // update the index : 

        // ab current node ke left right banayege : 
        root.left = create(preorder, index, min, root.data);
        root.right = create(preorder , index , root.data , max);

        // now after completing the construction of tree 
        // return the root : 
        return root;
    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        int preorder[] = {40 , 30 , 35 , 80 , 100};
        Node root = create_bst(preorder, preorder.length);
        preorder(root);
    }
}
