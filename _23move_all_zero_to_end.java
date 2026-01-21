import java.util.Scanner;

public class _23move_all_zero_to_end {
    public static void pushZeroToEnd(int arr[] , int n){

        // take the two pointer : 
        // phle hum starting se non zero element ko store karege : 
        int j = 0;
        for(int i = 0; i<n; i++){
            if(arr[i] != 0){
                arr[j++] = arr[i];
            }
        }
        // ab last tak remaining space me zero store karege : 
        while(j < n){
            arr[j++] = 0;
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
        System.out.println("enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        print(arr, n);
        pushZeroToEnd(arr, n);
        print(arr, n);

    }
}
