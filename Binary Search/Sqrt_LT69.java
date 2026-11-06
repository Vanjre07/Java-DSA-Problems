import java.util.*;
public class Sqrt_LT69 {
    public static int Square(int x){
        if (x < 0) {
            throw new IllegalArgumentException("x must be nonnegative");
        }
        long low = 0;
        long high = x;
        long ans = 1;

        while(low <= high){
            long mid = (low + high)/2;

            if(mid * mid <= x){
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        int x = 28;

        System.out.print(Square(x));
    }
}
