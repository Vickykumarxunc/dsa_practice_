public class _153nearest_multiple_of_10 {
    String roundToNearest(String str) {
        
        // length of the string: 
        int n = str.length();
        
        // first find the last digit of string : 
        int last_digit = str.charAt(n - 1) - '0';
        
        // creaate a character array : 
        char digit[] = str.toCharArray();
        
        // agar last digit less than or equal to 5 ho 
        // to last digit ko 0 kar do ; 
        if(last_digit <= 5){
            
            digit[n - 1] = '0';
        }
        
        // agar last digit 5 or 5 se badi ho : 
        // traverse from the reverse side : 
        // phle last digit ko '0' kar do :
        else{
            
        digit[n - 1] = '0';
        boolean carry = true;
        
        for(int i = n - 2; i>=0; i--){
            
            // agar digit 9 hai to carrry ke chance banege 
            // us digit par zero kar do : 
            if(digit[i] == '9'){
                
            digit[i] = '0';
            
            }
            else{
                // last digit se phle number ko ek se bada kar return kar jao : 
                digit[i] = (char)(digit[i] + 1);
                carry = false; // no chance of carry : 
                break;
            }
        }
        
        // if carry is still true if means we had something like 
        // 999 so prepend '1'
        if(carry){
            return '1' + new String(digit);
        }
        
        }
        
        return new String(digit);
    }
    public static void main(String[] args) {
        
    }
}
