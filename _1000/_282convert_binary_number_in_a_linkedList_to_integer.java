package _1000;
public class _282convert_binary_number_in_a_linkedList_to_integer {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static int getvalue(Node head){
        int sum = 0;
        Node temp = head;
        while(temp != null){
            sum = sum * 2 + temp.data;
            temp = temp.next;
        }
        return sum;
    }
    public static void main(String[] args) {
        
    }
}