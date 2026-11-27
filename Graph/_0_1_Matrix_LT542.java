import java.util.*;
public class _0_1_Matrix_LT542 {

    static class Node{
        int first;
        int second;
        int steps;

        Node(int first,int second,int steps){
            this.first = first;
            this.second = second;
            this.steps = steps;
        }
    }

    public static int[][] Matrix(int[][]grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][]vis = new int[n][m];
        int[][]dis = new int[n][m];
        Queue<Node> q = new LinkedList<>();
        int[]delrow = {-1,0,1,0};
        int[]delcol = {0,1,0,-1};

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(grid[row][col] == 0){
                    q.add(new Node(row,col,0));
                    vis[row][col] = 1;
                }
                else{
                    vis[row][col] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            Node node = q.poll();
            int row = node.first;
            int col = node.second;
            int steps = node.steps;

            dis[row][col] = steps;

            for(int i = 0; i < 4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >= 0 && nrow < n
                && ncol >= 0 && ncol < m
                && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add(new Node(nrow,ncol,steps + 1));
                }
            }
        }
        return dis;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] ans = Matrix(mat);

        for(int[] num : ans){
            System.out.print(Arrays.toString(num) + " ");
        }
    }
}
