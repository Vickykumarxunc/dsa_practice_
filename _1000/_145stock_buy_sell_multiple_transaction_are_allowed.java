package _1000;

public class _145stock_buy_sell_multiple_transaction_are_allowed {
    public static int buy_and_sell(int arr[] , int n){
        int profit = 0;
        for(int i = 1; i<n; i++){
            if(arr[i] > arr[i - 1]){
                profit += (arr[i] - arr[i - 1]);
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        
    }
}
