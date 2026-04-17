package _1000;
public class _240lcm_and_gcd_of_two_number{

    // simple 
    public static int gcd1(int x , int y){
        while(x != y){
            if(x > y){
                x = x - y;
            }
            else if(y > x){
                y = y - x;
            }
         }
        return x;
    }
    // optimal logn // euclidean algorithm 
    public static int gcd2(int x , int y){
        while(y != 0){
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
    // recursive : 
    public static int gcd3(int x , int y){

        // base condition : 
        if(y == 0){
            return x;
        }
        return gcd3(y , x % y);
    }
    public static int lcm(int x , int y){
        if(x == 0 || y == 0){
            return 0;
        }
        int gcd = gcd2(x , y);
        int lcm = (x * y)/gcd; // to over come the overflow (x / gcd)*y;
        return lcm;
    }
    public static void main(String[] args) {
        
    }
}