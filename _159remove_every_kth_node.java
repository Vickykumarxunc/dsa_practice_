public class _159remove_every_kth_node {
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
    public static Node delete(Node head , int k){
        
        // check mark : 
        if(head == null || head.next == null || k == 0){
            return head;
        }
        // remove all the node from the linkedlist : 
        if(k == 1){
            return null;
        }
        int count = 1;
        Node temp = head;

        while(temp != null && temp.next != null){

            if(count == k - 1){
                
                // delete the node : 
                temp.next = temp.next.next;
                count = 1;
            }
            else{
                count++;
            }
            temp = temp.next;
        }
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
    public static void main(String[] args) {
        Node head = null;
        head = insert(head , 1);
        head = insert(head , 2);
        head = insert(head , 3);
        head = insert(head , 4);
        head = insert(head , 5);
        head = insert(head , 6);
        head = insert(head ,7);
        head = insert(head , 8);

        print(head);

        int k = 2;
        head = delete(head , k);

        print(head);
    }
}
