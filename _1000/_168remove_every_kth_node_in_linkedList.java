package _1000;

public class _168remove_every_kth_node_in_linkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node remove(Node head, int k) {
        if (head == null || k == 1) {
            return null;
        }
        Node curr = head;
        int i = 1;

        while (curr != null) {
            i++;
            if (i == k) {
                if (curr.next != null) {
                    curr.next = curr.next.next;
                }
                i = 1;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
