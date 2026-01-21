import java.util.Scanner;

public class _129segregate0and1 {
    public static void segregate01(int arr[] , int n){
       
        int j = 0;
        for(int i = 0; i<n; i++){
            if(arr[i] == 0){
                arr[j] = arr[i];
                j++;
            }
        }
        while(j < n){
            arr[j++] = 1; 
        }
    }
    public static void segregate(int arr[] , int n){

        // two pointer : 
        int left = 0;
        int right = n - 1;

        while(left < right){

            if(arr[left] == 0){
                left++;
            }
            else if(arr[right] == 1){
                right--;
            }
            else{
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
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
        System.out.println("enter the array element  : ");
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        print(arr, n);
        segregate(arr, n);
        print(arr, n);
    }
}
