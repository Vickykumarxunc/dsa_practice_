import java.util.ArrayList;
import java.util.Scanner;

// order also maintained : 
public class _87move_all_negative_element_to_end {
    public static void rearrange(int arr[] , int n){

        // hum ek array list banayege jisme sirf negative element present hoge : 
        ArrayList<Integer> list = new ArrayList<>();
        
        // take a one pointer : jo positive elemetn ko fill karege : 
        int j = 0;
        for(int i = 0; i<n; i++){
            if(arr[i] >= 0){
                arr[j++] = arr[i];
            }
            else{
                // store negative element : 
                list.add(arr[i]);
            }
        } 
        // fill the negative element into the array : 
        for(int element : list){
            arr[j++] = element;
        }
    }
    public static void print(int arr[]){
        int n = arr.length;
        for(int i = 0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the aray : ");
        int n = sc.nextInt();
        System.out.println("enter the array element : ");
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        print(arr);
        rearrange(arr, n);
        print(arr);

    }
}
