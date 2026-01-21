public class _127pair_wise_swap_node_in_a_linkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node swap(Node head){

        // we use the 4 pointer : 
        Node curr = head; // current pointer current node ko point karega : 
        Node forward = null; // forward pointer pair ke second node ko point karege : 
        Node temp = null; // temp pointer next pair ko point karege : 
        Node prev = null; // prev pointer previous swap pair ke last point ko point karega : 

        // traverse the linkedlist : 
        // jab tak 2 node possible hai to swap possible hai : 
        while(curr != null && curr.next != null){

            forward = curr.next;
            temp = forward.next;
            // first time jab previous null hai 
            // to apane head ko update kar do  : 
            if(prev == null){
                head = forward;
            }
            else{
                prev.next = forward;
            }
            // now swap the pair : 
            forward.next = curr;
            curr.next = temp;
            prev = curr;
            curr = temp; // current ko ab dusre pair par le jao  : 
        }
        return head;
    }
    public static Node insert(Node head , int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return head;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }
    public static void display(Node head){
        if(head == null){
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = null;
        head = insert(head , 1);
        head = insert(head , 2);
        head = insert(head , 3);
        head = insert(head , 4);
        head = insert(head , 5);

        display(head);

        head = swap(head);

        display(head);
    }
}
