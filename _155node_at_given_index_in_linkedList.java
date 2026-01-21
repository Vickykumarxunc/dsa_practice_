public class _155node_at_given_index_in_linkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node createNode(Node head , int data){
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
    // one based indexing : 
    public static int getNode(Node head , int index){
        
        Node temp = head;
        int i = 1;
        while(temp != null){
            
            if(i == index){
                return temp.data;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public static void main(String[] args) {
        Node head = null;
        head = createNode(head, 1);
        head = createNode(head , 2);
        head = createNode(head , 3);
        head = createNode(head , 4);
        head = createNode(head , 5);
        head = createNode(head , 6);

        int getNode = getNode(head , 3);
        System.out.println(getNode);
    }
}
