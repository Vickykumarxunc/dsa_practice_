package _1000;

public class _147stock_buy_and_sell_at_most_k_transaction_allowed {
    public static int buy_and_sell(int arr[] , int n , int k){
        if(n == 0 || k == 0){
            return 0;
        }
        if(k >= n/2){
            int max_profit = 0;
            for(int i = 1; i<n; i++){
                if(arr[i] > arr[i - 1]){
                    max_profit += (arr[i] - arr[i - 1]);
                }
            }
            return max_profit;
        }
        int min[] = new int[k + 1];
        int profit[] = new int[k + 1];

        for(int i = 1; i<=k; i++){
            min[i] = Integer.MAX_VALUE;
            profit[i] = 0;
        }

        for(int i = 0; i<n; i++){
            for(int t = 1; t <= k; t++){
                min[t] = Math.min(min[i] , arr[i] - profit[t - 1]);
                profit[t] = Math.max(profit[t] , arr[i] - min[t]);
            }
        }
        return profit[k];
    }
    public static void main(String[] args) {
        
    }
}
