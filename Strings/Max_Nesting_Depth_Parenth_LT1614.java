import java.util.*;
public class Max_Nesting_Depth_Parenth_LT1614 {
    public static int Parenthesis(String S){
        int count = 0;
        int max = 0;

        for(char ch : S.toCharArray()){
            if(ch == '('){
                count++;
                max = Math.max(count,max);
            }
            else if(ch == ')'){
                count--;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String S = "(1+(2*3)+((8)/4))+1";
        System.out.print(Parenthesis(S));
    }
}
