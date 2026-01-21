import java.util.HashSet;

public class _50remove_duplicate_from_un_sorted_linkedList {
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
    public static Node remove_duplicate(Node head){

        // edge case : 
        if(head == null || head.next == null){
            return head;
        }
        // create a hash set which store the node of the linkedlist : 
        HashSet<Integer> set = new HashSet<>();

        // create a dummpy Node 
        Node dummyNode = new Node(-1);
        Node curr = head;
        Node prev = dummyNode;

        // traverse the list;
        while(curr != null){
            if(!set.contains(curr.data)){
                prev.next = curr;
                prev = prev.next;
            }
            // agar current node set and ander present hai to use skip kar do : 
            set.add(curr.data);
            curr = curr.next;
        }
        prev.next = null; 
        return dummyNode.next;
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
    public static void main(String[] args) {
        Node head = null;
        head = insert(head , 5);
        head = insert(head , 2);
        head = insert(head , 2);
        head = insert(head , 4);

        print(head);
        head = remove_duplicate(head);
        print(head);

    }
}
