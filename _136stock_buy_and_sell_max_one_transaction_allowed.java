import java.util.Scanner;

public class _136stock_buy_and_sell_max_one_transaction_allowed {
    public static int maximum_profit(int arr[] , int n){

        // let the first element is minimum : 
        int min = arr[0];
        int max_profit = 0;

        for(int i = 1; i<n; i++){

            // update the minimum value 
            min = Math.min(arr[i] , min);

            // update the maximum profit : 
            max_profit = Math.max(max_profit , arr[i] - min);
        }
        return max_profit;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        System.out.println("Enter the array element : ");
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = maximum_profit(arr, n);
        System.out.println("maximum profit = " + ans);
    }
}
/*
in order to maximize the profit , we need to minimize the cost price 
and maximize the selling price. so at every step , we keep the track of 
minimum buy price of stack . for every price we substract with the minimum so far
and if we get more profit than the current result we update the result . 
 */
