import java.util.*;
public class Count_Square_Submatrix_LT1277 {
    public static int Submatrix(int[][]matrix){
        int RowSize = matrix.length;
        int ColSize = matrix[0].length;

        int[][]DP = new int[RowSize][ColSize];

        for(int[]Row : DP){
            Arrays.fill(Row, -1);
        }

        int Count = 0;
        for(int row = 0; row < RowSize; row++){
            for(int col = 0; col < ColSize; col++){
                Count += MatrixCount(row,col,RowSize,ColSize,matrix,DP);
            }
        }

        return Count;
    }

    public static int MatrixCount(int row,int col,int RowSize,int ColSize,int[][]matrix,int[][]DP){
        if(row >= RowSize || col >= ColSize)
            return 0;

        if(matrix[row][col] == 0)
            return 0;

        if(DP[row][col] != -1)
            return DP[row][col];

        int Right = MatrixCount(row,col + 1,RowSize,ColSize,matrix,DP);
        int Down = MatrixCount(row + 1,col,RowSize,ColSize,matrix,DP);
        int Diagonal = MatrixCount(row + 1,col + 1,RowSize,ColSize,matrix,DP);

        DP[row][col] = 1 + Math.min(Right,Math.min(Down, Diagonal));

        return DP[row][col];
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        System.out.println("Total square submatrices with all ones: " + Submatrix(matrix));
    }
}
