import java.util.ArrayList;
import java.util.Scanner;
public class _154print_pattern {
    public static ArrayList<Integer> pattern(int n){
        ArrayList<Integer> list = new ArrayList<>();

        // agar negative element ho to vo same rahega : 
        if(n < 0){
            list.add(n);
            return list;
        }

        find1(n , list);

        // if number is divisible by 5 : 
        if(n % 5 == 0){
        find2(0 , n, list);
        }
        // number is not divide by 5 : 
        else{
            find2((5 - (n % 5)) , n , list);
        }

        return list;
    }
    public static void find1(int n , ArrayList<Integer> list){

        // base condition : 
        if(n <= 0){
            return;
        }
        // add the number into the list : 
        list.add(n);
        
        // again recursive call updated number :
        find1(n - 5 , list);
    }
    public static void find2(int m , int n,  ArrayList<Integer> list){
        
        // base condition : 
        if(m > n ){
            return;
        }
        // add the number into the list : 
        list.add(m);

        // again recursive call updated number : 
        find2(m + 5 , n , list);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the any number : ");
        int n = sc.nextInt();

        ArrayList<Integer> ans = new ArrayList<>();
        ans = pattern(n);
        System.out.println(ans);

    }
}

/*
Given a number n, print a sequence of numbers starting from n. Each next number in the sequence is n - 5, and this continues recursively until the number becomes less than or equal to 0. After that, print the sequence in reverse order, adding 5 each time, until it reaches back to the original number n.
Note: You must not use loops.
 */
