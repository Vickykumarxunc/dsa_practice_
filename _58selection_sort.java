import java.util.Scanner;

public class _58selection_sort {
    public static void sort(int arr[] , int n){
        for(int i = 0; i<n - 1; i++){
            int min_index = i;
            for(int j = i + 1; j<n; j++){
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
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
        int arr1[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr1[i] = sc.nextInt();
        }
        print(arr1, n);
        sort(arr1, n);
        print(arr1, n);
    }
}
