import java.util.*;
public class Triangle_Min_LT120 {
    public static int Triangle(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][]dp = new int[n][n];
        boolean[][]visited = new boolean[n][n];

        for(int[]row : dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,n,triangle,dp,visited);
    }

    public static int solve(int row,int col,int n,List<List<Integer>> triangle,int[][]dp,boolean[][]visited){
        if(row == n - 1)
            return triangle.get(row).get(col);

        if(visited[row][col])
            return dp[row][col];

        int down = solve(row + 1,col,n,triangle,dp,visited);
        int downRight = solve(row + 1,col + 1,n,triangle,dp,visited);

        dp[row][col] = triangle.get(row).get(col) + Math.min(down,downRight);

        visited[row][col] = true;
        return dp[row][col];
    }
    public static void main(String[] args) {
        List<List<Integer>> triangle = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
        );

        System.out.print(Triangle(triangle));
    }
}
