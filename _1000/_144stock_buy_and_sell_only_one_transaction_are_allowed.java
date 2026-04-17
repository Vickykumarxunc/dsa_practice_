package _1000;

public class _144stock_buy_and_sell_only_one_transaction_are_allowed {
    public static int buy_sell(int arr[] , int n){
        int min_element = arr[0];
        int max_profit = 0;
        for(int i = 1; i<n; i++){
            if(arr[i] < min_element){
                min_element = arr[i];
            }
            else{
                max_profit = Math.max(max_profit , arr[i] - min_element);
            }
        }
        return max_profit;
    }
    public static void main(String[] args) {
        
    }
}
