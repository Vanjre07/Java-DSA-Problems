import java.util.*;
public class Surrounded_Region_LT130 {
    public static void Surrounded(char[][]board){
        int n = board.length;
        int m = board[0].length;
        int[][]vis = new int[n][m];
        int[]delrow = {-1,0,1,0};
        int[]delcol = {0,1,0,-1};

        for(int i = 0; i < n; i++){
            if(vis[i][0] == 0 && board[i][0] == 'O'){
                DFS(i,0,vis,board,delrow,delcol);
            }
            if(vis[i][m - 1] == 0 && board[i][m - 1] == 'O'){
                DFS(i,m - 1,vis,board,delrow,delcol);
            }
        }

        for(int j = 0; j < m; j++){
            if(vis[0][j] == 0 && board[0][j] == 'O'){
                DFS(0,j,vis,board,delrow,delcol);
            }
            if(vis[n - 1][j] == 0 && board[n - 1][j] == 'O'){
                DFS(n - 1,j,vis,board,delrow,delcol);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void DFS(int row,int col,int[][]vis,char[][]board,int[]delrow,int[]delcol){
        vis[row][col] = 1;
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < 4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow >= 0 && nrow < n
            && ncol >= 0 && ncol < m
            && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O'){
                DFS(nrow,ncol,vis,board,delrow,delcol);
            }
        }
    }
    public static void main(String[] args) {
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};

        Surrounded(board);
        for(char[] ch: board){
            System.out.println(Arrays.toString(ch)+ " ");
        }
    }
}
