package _1000;

public class _246roman_to_integer {
    public static int number(char ch){
        if(ch == 'I') return 1;
        else if(ch == 'V') return 5;
        else if(ch == 'X') return 10;
        else if(ch == 'L') return 50;
        else if(ch == 'C') return 100;
        else if(ch == 'D') return 500;
        else if(ch == 'M') return 1000;
        return 0;
    }
    public static int roman_to_integer(String str){
        int sum = 0;
        for(int i = 0; i<str.length() - 1; i++){
            if(number(str.charAt(i)) < number(str.charAt(i + 1))){
                sum -= number(str.charAt(i));
            }
            else{
                sum += number(str.charAt(i));
            }
        }
        // last number always added : 
        sum += number(str.charAt(i - 1));
        return sum;
    }
    public static void main(String[] args) {
        
    }
}
