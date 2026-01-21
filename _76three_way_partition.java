import java.util.Scanner;

public class _76three_way_partition {
    public static void partition(int arr[] ,  int n, int a , int b){

        // apply the three pointer approach : dutch national flag : 
        int low = 0;
        int high = n - 1;
        int mid = 0;

        while(mid <= high){

            // agar element a se chota hai : to low and mid ko swap kar do : 
            if(arr[mid] < a){
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            }
            // agar element b se bada hai : to high and mid ko swap kar do : 
            else if(arr[mid] > b){
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
            // agar element a or b ke beech me hai to mid ko aage kar do bina swap ke : 
            else{
                mid++;
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
        System.out.println("enter the value of a : ");
        int a = sc.nextInt();
        System.out.println("enter the value of b : ");
        int b = sc.nextInt();

        print(arr, n);
        partition(arr, n, a, b);
        print(arr , n);


    }
}
/*
Given an array and a range a, b. The task is to partition the array around the range such that the array is divided into three parts.
1) All elements smaller than a come first.
2) All elements in range a to b come next.
3) All elements greater than b appear in the end.
The individual elements of three sets can appear in any order. You are required to return the modified array.
 */
