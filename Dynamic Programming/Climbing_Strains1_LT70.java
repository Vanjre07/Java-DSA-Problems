import java.util.Arrays;

public class Climbing_Strains1_LT70 {
    //Similar to Fibonacci Series
    public static int Stairs(int n){
        int[]dp = new int[n + 1];
        Arrays.fill(dp,-1);
        return Recurssion(dp,n);
    }

    public static int Recurssion(int[]dp,int n){
        if(n == 0)  return 1;
        if(n == 1)  return 1;
        if(dp[n] != -1) return dp[n];

        dp[n] = Recurssion(dp,n - 1) + Recurssion(dp, n - 2);

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.print(Stairs(3));
    }
}
