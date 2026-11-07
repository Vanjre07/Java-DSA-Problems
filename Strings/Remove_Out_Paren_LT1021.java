import java.util.*;
public class Remove_Out_Paren_LT1021 {
    public static String Parenthesis(String S){
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for(char ch : S.toCharArray()){
            if(ch == '('){
                if(count > 0){
                    sb.append(ch);
                }
                count++;
            }
            else{
                count--;
                if(count > 0){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String S= "(()())(()())";

        System.out.print(Parenthesis(S));
    }
}
