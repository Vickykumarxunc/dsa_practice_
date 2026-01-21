public class _36remove_duplicate_from_sorted_linkedList {
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
    public static Node remove(Node head){
        
        // base condition ; 
        // empty list or ek node ki list hamesa unique hota hai : 
        if(head == null || head.next == null){
            return head;
        }
        // take two pointer : 
        Node prev = head;
        Node curr = head.next;

        // travese the linkedlist : 
        while(curr != null){

            // agar current node ka data previous node ke data ke equal nahi hai 
            // to previous ke next current node par attach kar do 
            if(curr.data != prev.data){
                prev.next = curr;
                prev = prev.next;
            }
            // agar current node ka data previous node ke barabar hai to current pointer ko aage kar do : 
            curr = curr.next;
        }
        // last ke sare duplicate element remove ho jayege ; 
        // prev.next = ka null kar do : 
        prev.next = null;
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
        head = insert(head , 2);
        head = insert(head , 2);
        head = insert(head , 4);
        head = insert(head , 5);

        display(head);
        head = remove(head);
        display(head);
    }
}
