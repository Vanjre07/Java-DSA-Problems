import java.util.*;
public class Roman_Inte_LT13 {
    public static int Roman(String S){
        int ans = 0;
        int num = 0;
        for(int i = S.length() - 1; i >= 0; i--){
            switch (S.charAt(i)){
                case 'I': num = 1;
                break;
                case 'V': num = 5;
                break;
                case 'X': num = 10;
                break;
                case 'L': num = 50;
                break;
                case  'C' : num = 100;
                break;
                case 'D': num = 500;
                break;
                case 'M': num = 1000;
                break;
            }
            if(num * 4 < ans){
                ans -= num;
            }
            else{
                ans += num;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String S = "IXXX";
        System.out.println(Roman(S));
    }
}
