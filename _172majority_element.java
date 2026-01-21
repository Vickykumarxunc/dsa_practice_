import java.util.Scanner;

public class _172majority_element {
    public static int majorityElement(int arr[] , int n){

        // here we use the booye moore voting algorithm : 
        int value = arr[0];
        int count = 1;

        for(int i = 1; i<n; i++){

            if(arr[i] == value){
                count++;
            }
            else{
                count--;
            }
            if(count == 0){
                value = arr[i];
                count = 1;
            }
        }
        int freq = 0;
        for(int i = 0; i<n; i++){
            if(arr[i] == value){
                freq++;
            }
        }
        return freq > n/2 ? value : -1;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = majorityElement(arr, n);
        System.out.println(ans);
    }
}
