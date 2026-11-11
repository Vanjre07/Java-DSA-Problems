import java.util.*;
public class Fibanocci_LT509 {
    public static int FibanocciSeries(int n){
        int[]dp = new int[n + 1];
        Arrays.fill(dp,-1);

        return (rec(dp,n - 1) + rec(dp, n- 2));
    }

    public static int rec(int[]dp, int n){
        if(n <= 1)  return n;
        if(dp[n] != -1) return dp[n];

        return dp[n] = rec(dp, n - 1) + rec(dp, n - 2);
    }
    public static void main(String[] args) {
        System.out.println(FibanocciSeries(6));
    }
}
