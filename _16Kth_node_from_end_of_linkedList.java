public class _16Kth_node_from_end_of_linkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
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
    public static int get(Node head , int k){
        // take two pointer appraoch : 
        Node first = head;
        Node second = head;

        // first pointer ko second wale pointer se k step aage le jao : 
        for(int i = 0; i<k; i++){
            if(first == null){
                return -1;
            }
            first = first.next;
        }
        // ab loop jab tak chalao tab tak first null na ho jai : 
        while(first != null){
            // dono pointer ko ek sath aage badao : 
            first = first.next;
            second = second.next;
        }
        // return kar do second pointer ka data : 
        return second.data;
    }
    public static void main(String[] args) {
        Node head = null;
        head = insert(head , 1);
        head = insert(head , 2);
        head = insert(head , 3);
        head = insert(head , 4);
        head = insert(head , 5);
        head = insert(head , 6);
        head = insert(head , 7);
        head = insert(head , 8);
        head = insert(head , 9);

        int kthNode = get(head, 2);
        System.out.println("kth node of the linkedlist = " + kthNode);
    }
}
