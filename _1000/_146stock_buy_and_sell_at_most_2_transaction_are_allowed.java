package _1000;

public class _146stock_buy_and_sell_at_most_2_transaction_are_allowed {
    public static int buy_and_sell(int arr[] , int n){

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int profit1 = 0;
        int profit2 = 0;

        for(int i = 0; i<n; i++){
            
            min1 = Math.min(min1 , arr[i]);
            profit1 = Math.max(profit1 , arr[i] - min1);

            min2 = Math.min(min2, arr[i] - profit1);
            profit2 = Math.max(profit2 , arr[i] - min2);
        }
        return profit2;
    }
    public static void main(String[] args) {
        
    }
}
