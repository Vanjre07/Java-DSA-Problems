import java.util.*;
public class Number_of_Enclaves_LT1020 {

    static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }

    public static int Enclaves(int[][]grid){
        int n = grid.length;
        int m = grid[0].length;
        boolean [][]vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        int count = 0;
        int[]delrow = {-1,0,1,0};
        int[]delcol = {0,1,0,-1};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || i == n - 1 || j == m - 1){
                    if(grid[i][j] == 1) {
                        vis[i][j] = true;
                        q.add(new Pair(i,j));
                    }
                }
            }
        }

        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.first;
            int col = p.second;

            for(int i = 0; i < 4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >= 0 && nrow < n
                && ncol >= 0 && ncol < m
                && grid[nrow][ncol] == 1 && !vis[nrow][ncol]){
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};

        System.out.print(Enclaves(grid));
    }
}
