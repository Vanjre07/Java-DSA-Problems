import java.util.*;
public class Valid_Parenthesis_LT678 {
    public static boolean Parenthesis(String s){
        int min = 0;
        int max = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                max++;
                min++;
            }
            else if(ch == ')'){
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }
            if(min < 0) min = 0;
            if(max < 0) return false;
        }

        return min == 0;
    }
    public static void main(String[] args) {
        String s = "(*))";
        System.out.print(Parenthesis(s));
    }
}
