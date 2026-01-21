import java.util.Scanner;

public class _47insertion_sort {
    public static void insertionSort(int arr[] , int n){
        for(int i = 1; i<n-1; i++){
            int j = i;
            while(j > 0 && arr[j] < arr[j - 1]){
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }
    public static void print(int arr[] , int n){
        for(int i = 0; i<n; i++){
            System.out.print(arr[i] + " ");
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
        print(arr, n);
        insertionSort(arr, n);
        print(arr, n);
    }
}
