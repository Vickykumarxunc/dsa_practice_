package _1000;

public class _65delete_in_doubly_linkedList {
    public static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node delete(Node head, int pos) {
        if (head == null) {
            return head;
        }
        if (pos == 1) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return head;
        }
        Node temp = head;
        for (int i = 1; temp != null && i < pos; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            return head;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
