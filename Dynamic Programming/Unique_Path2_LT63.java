import java.util.*;
public class Unique_Path2_LT63 {
    public static int Unique(int[][]Paths){
        int n = Paths.length;
        int m = Paths[0].length;

        int [][]dp = new int[n][m];

        for(int[]row : dp){
            Arrays.fill(row,-1);
        }

        return solve(n - 1,m - 1,Paths,dp);
    }

    public static int solve(int row,int col,int[][]paths,int[][]dp){
        if(row < 0 || col < 0)  return 0;

        if(paths[row][col] == 1 )return 0;

        if(row == 0 && col== 0)    return 1;

        if(dp[row][col] != -1)  return dp[row][col];

        int MoveDown = solve(row - 1,col,paths,dp);
        int MoveRight = solve(row, col - 1,paths,dp);

        dp[row][col] = MoveDown + MoveRight;
        return dp[row][col];
    }
    public static void main(String[] args) {
        int[][] paths = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        System.out.print(Unique(paths));
    }
}
