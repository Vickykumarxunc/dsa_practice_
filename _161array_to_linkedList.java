import java.util.Scanner;

public class _161array_to_linkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node create(int arr[] , int n){
        Node head = new Node(arr[0]);
        Node temp = head;

        for(int i = 1; i<n; i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
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
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Node head = create(arr, n);
        print(head);
    }
}
