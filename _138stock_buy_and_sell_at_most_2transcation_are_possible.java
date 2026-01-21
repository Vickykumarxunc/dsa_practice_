import java.util.Scanner;

public class _138stock_buy_and_sell_at_most_2transcation_are_possible {
    public static int maximum_profixt(int arr[] , int n){

        // hum yaha par 4 variable maintain karege : 
        int min1 = Integer.MAX_VALUE; // buy1
        int min2 = Integer.MAX_VALUE; // buy2 (price - profit1)

        int profit1 = Integer.MIN_VALUE; // profit after the buy1 
        int profit2 = Integer.MIN_VALUE; // profit after the buy2 

        for(int i = 0; i<n; i++){

            // maintain the minimum 1 element : 
            min1 = Math.min(min1 , arr[i]);

            // find the profit1 : 
            profit1 = Math.max(profit1 , arr[i] - min1);

            // maintain the minimum 2 element : 
            min2 = Math.min(min2 , arr[i] - profit1);

            // find the profit 2 : 
            profit2 = Math.max(profit2 , arr[i] - min2);
        }
        return profit2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        System.out.println("Enter the array element : ");
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = maximum_profixt(arr, n);
        System.out.println(ans);

    }
}
