import java.util.HashSet;
public class _142count_pair_sum_in_two_linkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static int countPair(Node head1 ,Node head2 , int target){

        // base condition: 
        if(head1 == null || head2 == null){
            return 0;
        }
        // create a hashset to store the node of one list : 
        HashSet<Integer> set = new HashSet<>();
        Node temp = head1;

        // traverse the list 1 and store into the set : 
        while(temp != null){
            set.add(temp.data);
            temp = temp.next;
        }
        // now traverse the list 2 and check the pair element : 
        temp = head2;
        int count = 0;
        while(temp != null){
            
            if(set.contains(target - temp.data)){
                count++;
            }
            temp = temp.next;
        }
        return count;
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
        Node head1 = null;
        head1 = insert(head1 , 7);
        head1 = insert(head1 , 5);
        head1 = insert(head1 , 1);
        head1 = insert(head1 , 3);

        Node head2 = null;
        head2 = insert(head2 , 3);
        head2 = insert(head2 , 5);
        head2 = insert(head2 , 2);
        head2 = insert(head2 , 8);

        int target = 10;

        int countpair = countPair(head1, head2, target);
        System.out.println("total pair = present = " + countpair);
    }
}
