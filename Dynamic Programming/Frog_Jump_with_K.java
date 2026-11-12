import java.util.*;
public class Frog_Jump_with_K {
    public static int FrogJump(int[]heights,int k){
        int n = heights.length;
        int []dp = new int[n + 1];
        Arrays.fill(dp,-1);

        return Recurssion(heights,k,n - 1,dp);
    }

    public static int Recurssion(int[]heights,int k,int n,int []dp){
        if(n == 0)  return 0;
        if(dp[n] != -1) return dp[n];

        int min = Integer.MAX_VALUE;

        for(int index = 1; index <= k; index++){
            if(n - index >= 0){
                int jump = Recurssion(heights,k,n - index,dp) + Math.abs(heights[n] - heights[n - index]);
                min = Math.min(jump,min);
            }
        }
        dp[n] = min;
        return dp[n];
    }

    public static void main(String[] args) {
        int[]heights = {10, 30, 40, 50, 20};
        int k = 3;
        System.out.println(FrogJump(heights,k));
    }
}
