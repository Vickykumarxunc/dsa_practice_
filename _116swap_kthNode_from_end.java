

public class _116swap_kthNode_from_end {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node swapNode(Node head , int k){
        if(head == null){
            return head;
        }
        
        // first find the position of the kth node from the begin and last 
        // and maintain their previous node also : 
        Node first = head;
        Node second = head;
        Node secondprev = null;
        Node begin = head;
        Node beginprev = null;

        for(int i = 1; i<k; i++){
            first = first.next;
            beginprev = begin;
            begin = begin.next;
        }
        while(first.next != null){
            first = first.next;
            secondprev = second;
            second = second.next;
        }
        // now swap the node : 
        if(beginprev != null){
            beginprev.next = second;
        }
        else{
            head = second; // begin was head; 
        }
        if(secondprev != null){
            secondprev.next = begin;
        }
        else{
            head = begin; // second was head;
        }
        // swap next pointer  
        Node temp = begin.next;
        begin.next = second.next;
        second.next = temp;

        return head;
    }
    public static void print(Node head){
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
    public static void main(String[] args) {
        Node head = null;
        head = insert(head , 1);
        head = insert(head , 2);
        head = insert(head , 3);
        head = insert(head , 4);
        head = insert(head , 5);
        print(head);

        head = swapNode(head, 2);
        print(head);
    }
}
