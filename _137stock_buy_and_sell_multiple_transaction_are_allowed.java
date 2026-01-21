import java.util.Scanner;

public class _137stock_buy_and_sell_multiple_transaction_are_allowed {
    public static int maximum_profit(int arr[] , int n){

        int max_profict = 0;

        // jab bhi chota sa profit ho use add karte chale jao : 
        for(int i = 1; i<n; i++){
            if(arr[i] > arr[i - 1]){
                max_profict += (arr[i] - arr[i - 1]);
            }
        }
        return max_profict;
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
        int ans = maximum_profit(arr, n);
        System.out.println("maximum profit = "  + ans);
    }
}

/*
the idea is that profit only comes when price raise. if the price goes up
from one day to the next day , we can think of it as buying yesterday and selling today. 
instead of waiting for the exact bottom and top , we simply grab every small upward move. 
adding these small gains together is the same as if we had bought at each valley and sold 
at each peak because every rise between them gets counted . 
 */
