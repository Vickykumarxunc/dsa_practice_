package _1000;

public class _163node_at_given_index_in_linkedlist {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static int search(Node head, int index) {
        if (head == null) {
            return -1;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            if (temp == null) {
                return -1;
            }
            temp = temp.next;
        }
        return temp.data;
    }

    public static void main(String[] args) {

    }
}
