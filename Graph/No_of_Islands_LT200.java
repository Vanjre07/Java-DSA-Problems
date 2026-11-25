import java.util.*;
public class No_of_Islands_LT200 {

    public static int Islands(char[][]grid){
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean[][]vis = new boolean[n][m];

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(!vis[row][col] && grid[row][col] == '1'){
                    count++;
                    /* BFS
                    BFS.bfs(row,col,grid,vis); */

                    // DFS
                    DFS.dfs(row,col,grid,vis);
                }
            }
        }
        return count;
    }
    static class Pair{
        int first;
        int second;

        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }

    static class BFS{
        public static void bfs(int row,int col,char[][]grid,boolean[][]vis){
            int n = grid.length;
            int m = grid[0].length;

            vis[row][col] = true;
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(row,col));

            int[]delrow = {-1,0,1,0};
            int[]delcol = {0,1,0,-1};

            while(!q.isEmpty()){
                Pair P = q.poll();

                for(int i = 0; i < 4; i++){
                    int nrow = P.first + delrow[i];
                    int ncol = P.second + delcol[i];

                    if(nrow >= 0 && nrow < n
                    && ncol >= 0 && ncol < m
                    && grid[nrow][ncol] == '1' && !vis[nrow][ncol]){
                        vis[nrow][ncol] = true;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
    }

    static class DFS{
        public static void dfs(int row,int col,char[][]grid,boolean[][]vis){
            int n = grid.length;
            int m = grid[0].length;

            vis[row][col] = true;

            int[]delrow = {-1,0,1,0};
            int []delcol = {0,1,0,-1};

            for(int i = 0; i < 4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >= 0 && nrow < n
                && ncol >= 0 && ncol < m
                && grid[nrow][ncol] == '1' && !vis[nrow][ncol]){
                    dfs(nrow,ncol,grid,vis);
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};

        System.out.print(Islands(grid));
    }
}
