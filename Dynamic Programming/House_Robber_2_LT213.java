import java.util.*;
public class House_Robber_2_LT213 {
    public static int Robber(int[]nums){
        int n = nums.length;
        if(n == 1)  return nums[0];

        int IncStart = LinearRob(0,n - 2,nums);
        int IncEnd = LinearRob(1,n - 1,nums);

        return Math.max(IncStart,IncEnd);
    }

    public static int LinearRob(int start,int end,int[]nums){
        int[]dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return Solve(start,end,nums,dp);
    }

    public static int Solve(int start,int end,int[]nums,int[]dp){
        if(end < start) return 0;
        if(start == end)    return nums[start];
        if(dp[end] != -1)   return dp[end];

        int Rob = nums[end] + Solve(start,end - 2,nums,dp);
        int NotRob = Solve(start,end - 1,nums,dp);

        dp[end] = Math.max(Rob,NotRob);

        return dp[end];
    }
    public static void main(String[] args) {
        int[]nums = {1,2,3,1};
        System.out.print(Robber(nums));
    }
}
