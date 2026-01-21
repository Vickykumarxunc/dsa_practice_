public class _99intersection_of_two_sorted_linkedList {
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
    public static Node intersection(Node head1 , Node head2){

        // create a dummy Node : 
        Node dummyNode = new Node(-1);
        Node curr = dummyNode;

        // take two pointer which traverse on two linkedlist : 
        Node temp1 = head1;
        Node temp2 = head2;

        // traverse both the linkedlist : 
        while(temp1 != null && temp2 != null){

            if(temp1.data == temp2.data){

                 curr.next = new Node(temp1.data); // without changing the original list : 
                 curr = curr.next;

                 temp1 = temp1.next;
                 temp2 = temp2.next;
            }
            else if(temp1.data < temp2.data){
                temp1 = temp1.next;
            }
            else{
                temp2 = temp2.next;
            }
        }
        curr.next = null;
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
        Node head1 = null;
        head1 = insert(head1 , 1);
        head1 = insert(head1 , 2);
        head1 = insert(head1 , 3);
        head1 = insert(head1 , 4);
        head1 = insert(head1 , 6);
        print(head1);

        Node head2 = null;
        head2 = insert(head2 , 2);
        head2 = insert(head2 , 4);
        head2 = insert(head2 , 6);
        head2 = insert(head2 , 8);
        print(head2);

        Node newHead = intersection(head1, head2);
        print(newHead);





    }
}
