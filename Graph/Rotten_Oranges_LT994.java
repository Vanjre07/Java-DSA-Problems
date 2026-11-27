import java.util.*;
public class Rotten_Oranges_LT994 {

    static class Pair{
        int first;
        int second;
        int time;

        Pair(int first,int second,int time){
            this.first = first;
            this.second = second;
            this.time = time;
        }
    }

    public static int RottenOranges(int[][]grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][]vis = new int[n][m];
        int fresh = 0;
        int time = 0;
        int count = 0;

        int[]delrow = {-1,0,1,0};
        int[]delcol = {0,1,0,-1};
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 2;
                }
                else vis[i][j] = 0;
                if(grid[i][j] == 1)fresh++;
            }
        }

        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.first;
            int col = p.second;
            int tm = p.time;
            time = Math.max(time,tm);

            for(int i = 0; i < 4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >= 0 && nrow < n
                && ncol >= 0 && ncol < m
                && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                    q.add(new Pair(nrow,ncol,tm + 1));
                    vis[nrow][ncol] = 2;
                    count++;
                }
            }
        }

        if(count != fresh)  return -1;
        return time;
    }
    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int minutes = RottenOranges(grid);
        System.out.println("Minimum minutes to rot all oranges: " + minutes);
    }
}
