package _1000;
import java.util.ArrayList;

public class _162print_pattern {
    public static ArrayList<Integer> print_pattern(int n){
        ArrayList<Integer> list = new ArrayList<>();
        if(n == 0 || n < 0){
            list.add(n);
            return list;
        }
        reverse(n , list);
        if(n % 5 == 0){
            forward(0 , n , list);
        }
        else{
            forward((5 - (n % 5)) , n , list);
        }
        return list;
    }
    public static void reverse(int n , ArrayList<Integer> list){
        if(n <= 0){
            return;
        }
        list.add(n);
        reverse(n - 5 , list);
    }
    public static void forward(int m , int n , ArrayList<Integer> list){
        if(m > n){
            return;
        }
        list.add(m);
        forward(m + 5 , n , list);
    }
    public static void main(String[] args) {
        
    }
}
