import java.util.ArrayList;
import java.util.Scanner;
public class _162indexes_of_subarray_sum {

    // it is only work with the positive element : : : : : 
    public static ArrayList<Integer> subarray_index(int arr[] , int target , int n){

        ArrayList<Integer> list = new ArrayList<>();
        // use the two pointer approach : 
        int j = 0;
        int sum = 0;
        for(int i = 0; i<n; i++){
            
            // calculate the sum  
            sum += arr[i];

            // agar sum jyada ho jaye to use kar karo
            while(j < i && sum > target){
                sum -= arr[j];
                j++;
            }

            // agar phla subarray miljaye to vahi stop ho jao : 
            if(sum == target){
                list.add(j + 1);
                list.add(i + 1);
                break;
            }
        }
        if(list.isEmpty()){
            list.add(-1);
        }
        return list;
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
        System.out.println("enter the target sum : ");
        int target = sc.nextInt();
        ArrayList<Integer> ans = subarray_index(arr, target, n);
        System.out.println(ans);

    }
}
