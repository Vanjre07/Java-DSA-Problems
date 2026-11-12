import java.util.*;
public class House_Robber_1_LT198 {
    public static int Max_Sum(int[]nums){
        int n = nums.length;
        int []dp =  new int[n];
        Arrays.fill(dp,-1);

        return recurssion(nums,n - 1,dp);
    }
    public static int recurssion(int[]nums,int n,int []dp){
        if(n < 0)   return 0;
        if(n == 0)  return nums[n];
        if(dp[n] != -1) return dp[n];

        int pick = nums[n] + recurssion(nums,n - 2,dp);
        int notPick = recurssion(nums,n - 1,dp);
        dp[n] = Math.max(pick,notPick);
        return dp[n];
    }
    public static void main(String[] args) {
        int[]nums = {2,1,4,9};
        System.out.print(Max_Sum(nums));
    }
}
