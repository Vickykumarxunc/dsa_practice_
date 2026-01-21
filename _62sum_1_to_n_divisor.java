
import java.util.Scanner;

public class _62sum_1_to_n_divisor {
    public static int find(int n){

        // hum ye dekhege har division apane multiple me kitni baar aata hai : 
        int sum = 0;
        for(int i = 1; i<= n; i++){
            sum += i * (n / i);
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the any number : ");
        int n = sc.nextInt();

        int ans = find(n);
        System.out.println("sum = " + ans);

    }
}

/*
Divisor = 1

1 divisor kis–kis number ko divide karta hai?
1,2,3,4,5,6 → 6 numbers
So 1 contributes → 1 × 6

Divisor = 2

2 divisor kis–kis ko divide karega?
2,4,6 → 3 numbers
Contribution → 2 × 3

Divisor = 3

3,6 → 2 numbers
Contribution → 3 × 2

Divisor = 4

4 → 1
Contribution → 4 × 1

Divisor = 5

5 → 1
Contribution → 5 × 1

Divisor = 6

6 → 1
Contribution → 6 × 1
 */
