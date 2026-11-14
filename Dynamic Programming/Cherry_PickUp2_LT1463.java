import java.util.*;
public class Cherry_PickUp2_LT1463 {

    private static final int IMPOSSIBLE = -100000;
    public static int Cherry(int[][]grid){
        int row = grid.length;
        int col = grid[0].length;

        int[][][]Dp = new int[row][col][col];

        for(int[][]firstRow : Dp){
            for(int[]secondRow : firstRow){
                Arrays.fill(secondRow,-1);
            }
        }
        return CountCherries(0,0,col - 1,row,col,grid,Dp);
    }

    public static int CountCherries(int row,int col1,int col2,int RSize,int CSize,int[][]grid,int[][][]Dp){
        if(col1 < 0 || col2 < 0 || col1 >= CSize || col2 >= CSize)
            return IMPOSSIBLE;

        if(row == RSize - 1){
            if(col1 == col2){
                return grid[row][col1];
            }
            else{
                return grid[row][col1] + grid[row][col2];
            }
        }

        if(Dp[row][col1][col2] != -1)
            return Dp[row][col1][col2];

        int max = IMPOSSIBLE;

        for(int C1 = -1; C1 <= 1; C1++){
            for(int C2 = -1; C2 <= 1; C2++){
                int value = 0;
                if(col1 == col2){
                    value = grid[row][col1];
                }
                else{
                    value = grid[row][col1] + grid[row][col2];
                }

                value += CountCherries(row + 1,col1 + C1, col2 + C2,RSize,CSize,grid,Dp);
                max = Math.max(max,value);
            }
        }

        Dp[row][col1][col2] = max;
        return Dp[row][col1][col2];
    }
    public static void main(String[] args) {
        int[][]grid = {{3,1,1},
                       {2,5,1},
                       {1,5,5},
                       {2,1,1}};

        System.out.print(Cherry(grid));
    }
}
