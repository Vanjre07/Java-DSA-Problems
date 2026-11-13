import java.util.*;
public class Unique_Path1_LT62 {
    public static int UniquePath(int m,int n){
        int [][]dp = new int[m][n];

        for(int []row : dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,m,n,dp);
    }

    public static int solve(int row,int col,int m,int n,int[][]dp){
        if(row == m - 1 && col == n - 1){
            return 1;
        }

        if(row >= m || col >= n){
            return 0;
        }
        if(dp[row][col] != -1) return dp[row][col];

        int downmove = solve(row + 1,col,m,n,dp);
        int rightmove = solve(row,col + 1,m,n,dp);

        dp[row][col] = downmove + rightmove;

        return dp[row][col];
    }
    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        System.out.print(UniquePath(m,n));
    }
}
