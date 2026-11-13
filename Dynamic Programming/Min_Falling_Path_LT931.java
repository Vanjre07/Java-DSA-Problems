import java.util.*;
public class Min_Falling_Path_LT931 {
    public static int MinPath(int[][]matrix){
        int row = matrix.length;
        int[][]dp = new int[row][row];

        for(int[]rows : dp){
            Arrays.fill(rows,100000);
        }
        int ans = 100000;
        for(int col = 0; col < row; col++){
            ans = Math.min(ans,solve(row - 1,col,matrix,dp));
        }
        return ans;
    }

    public static int solve(int row,int col,int[][]matrix,int[][]dp){
        if(col < 0 || col >= matrix[0].length)  return 100000;
        if(row == 0 )   return matrix[row][col];
        if(dp[row][col] != 100000)  return dp[row][col];

        int moveUp = solve(row - 1,col,matrix,dp);
        int moveleftDia = solve(row - 1,col - 1,matrix,dp);
        int moverightDia = solve(row - 1,col + 1,matrix,dp);

        int best = Math.min(moveUp,Math.min(moveleftDia,moverightDia));

        dp[row][col]  = best + matrix[row][col];
        return dp[row][col];
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };

        System.out.print(MinPath(matrix));
    }
}
