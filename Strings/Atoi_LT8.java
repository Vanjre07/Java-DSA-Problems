import java.util.*;
public class Atoi_LT8 {
    public static int Str_Int(String S){
        int num = 0;
        int sign = 1;
        int i = 0;

        while(i < S.length() && S.charAt(i) == ' ')   i++;

        if(i < S.length()){
            if(S.charAt(i) == '-'){
                sign = -1;
                i++;
            }
            else if(S.charAt(i) == '+'){
                i++;
            }
        }

        while(i < S.length() && isDigit(S.charAt(i))){
            int digit = S.charAt(i) - '0';

            if(num == Integer.MAX_VALUE / 10){
                if(sign == 1){
                    if(digit >= 7)  return Integer.MAX_VALUE;
                }
                else if(sign == -1){
                    if(digit == -1) return Integer.MIN_VALUE;
                }
            }

            if(num > Integer.MAX_VALUE / 10){
                if(sign == 1)   return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return num * sign;
    }

    public static boolean isDigit(char ch){
        return ch >= '0' && ch <= '9';
    }
    public static void main(String[] args) {
        String S = "1337c0d3";
        System.out.print(Str_Int(S));
    }
}
