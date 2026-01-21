import java.util.*;
public class _61count_triplet {
    public static int count(int arr[] , int n){

        // phle hum array ko sort kar lege taki complexity reduce ho sake : 
        Arrays.sort(arr);
        int count = 0;

        // ab hum outer loop reverse order me lagayege : 
        for(int i = n - 1; i>= 2; i--){

            // ab 2 pointer lo : 
            int left = 0; 
            int right = i - 1;

            // ab left aur right ke beech me check karo 
            while(left < right){
                
                int sum = arr[left] + arr[right];
                if(sum == arr[i]){
                    count++;
                    left++;
                    right--;
                }
                else if(sum > arr[i]){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return count;
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
        int count = count(arr, n);
        System.out.println("no of triplet = " + count);
    }
}
