import java.util.*;
public class Min_Cost_Ticket_LT983 {
    public static int MinCost(int[]days,int []cost){
        int []dp = new int[days.length];
        Arrays.fill(dp,-1);

        return solve(0,days,cost,dp);
    }

    public static int solve(int index,int[]days,int[]cost,int []dp){
        if(index >= days.length) return 0;
        if(dp[index] != -1) return dp[index];

        int oneday = cost[0] + solve(index + 1,days,cost,dp);

        int i = index;
        while( i < days.length && days[i] < days[index] + 7) i++;
        int sevenday = cost[1] + solve(i,days,cost,dp);

        i = index;
        while(i < days.length && days[i] < days[index] + 30)  i++;
        int thirtyday = cost[2] + solve(i,days,cost,dp);

        dp[index] = Math.min(oneday,Math.min(sevenday,thirtyday));

        return dp[index];
    }
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] cost = {2, 7, 15};

        System.out.print(MinCost(days, cost));
    }
}
