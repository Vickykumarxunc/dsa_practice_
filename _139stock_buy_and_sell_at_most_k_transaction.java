
import java.util.Scanner;

public class _139stock_buy_and_sell_at_most_k_transaction {
    public static int maximum_profit(int arr[] , int n , int k){

        // key point is : 
        // t-th buy ka effective cost : 
        // mint = Math.min(mint , arr[i] - profit(t - 1))

        // t-th sell ka profit : 
        // profitt = Math.max(profitt , arr[i] - mint)

        // time complexity = O(n.k)
        // space complexity = O(K)

        if(n == 0 || k == 0){
            return 0;
        }

        // special case : unlimited transaction : 
        if(k >= n/2){
            int max_profit = 0;
            for(int i = 1; i<n; i++){
                if(arr[i] > arr[i - 1]){
                    max_profit += (arr[i] - arr[i - 1]);
                }
            }
            return max_profit;
        }
        // create a two array of the size K ; 
        // which store the value of min and profit of k transaction : 
        int min[] = new int[k + 1];
        int profit[] = new int[k + 1];

        // initialize the minimum array by positve large number : 
        // initialize the profit array by zero : 
        for(int i = 1; i<= k; i++){
            min[i] = Integer.MAX_VALUE;
            profit[i] = 0;
        }
        
        // now traverse the given array and find the maximum profit of kth transaction : 
        for(int i = 0; i<n; i++){
            for(int t = 1; t<=k; t++){

                min[t] = Math.min(min[t] , arr[i] - profit[t - 1]);
                profit[t] = Math.max(profit[t] , arr[i] - min[t]);
            }
        }
        return profit[k];
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
        System.out.println("enter the value of k : ");
        int k = sc.nextInt();

        int ans = maximum_profit(arr, n, k);
        System.out.println(ans);
    }
}
