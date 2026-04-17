package _1000;

import java.util.ArrayList;

public class _227first_n_fibonacci_number {
    public static ArrayList<Integer> fibonacciNumber(int n){
        ArrayList<Integer> list = new ArrayList<>();
        if(n <= 0){
            return list;
        }
        int a = 0;
        int b = 1;
         
        for(int i = 1; i<=n; i++){
            list.add(a);
           int c = a + b;
            a = b;
            b = c;
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
