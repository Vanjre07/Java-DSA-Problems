import java.util.*;
public class Set_Matrix_Zero_73 {

    static class Brute_Force{
        public static void setZeroes(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;

            boolean []row = new boolean[n];
            boolean []col = new boolean[m];

            for(int i=0; i<n; i++){
                for(int j = 0; j < m; j++){
                    if(matrix[i][j] == 0){
                        row[i] = true;
                        col[j] = true;
                    }
                }
            }

            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    if(row[i] || col[j]){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }

    static class OptimalSolution{
        public static void setZeroes(int[][] matrix){
            int rows = matrix.length;
            int cols = matrix[0].length;

            int col0 = 1;

            for(int row = 0; row < rows; row++){
                for(int col = 0; col < cols; col++){
                    if(matrix[row][col] == 0){
                        matrix[row][0] = 0;
                        if(col != 0) matrix[0][col] = 0;
                        else col0 = 0;
                    }
                }
            }

            for(int row = 1; row < rows; row++){
                for(int col = 1; col < cols; col++){
                    if(matrix[row][col] != 0){
                        if(matrix[0][col] == 0 || matrix[row][0] == 0){
                            matrix[row][col] = 0;
                        }
                    }
                }
            }

            if(matrix[0][0] == 0){
                for(int col = 0; col < cols; col++){
                    matrix[0][col] = 0;
                }
            }

            if(col0 == 0){
                for(int row = 0; row < rows; row++){
                    matrix[row][0] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 0, 4},
                {5, 6, 7, 8},
                {9, 0, 11, 12},
                {13, 14, 15, 16}
        };

        //Brute_Force.setZeroes(matrix);
        OptimalSolution.setZeroes(matrix);
        printMatrix(matrix);
    }

    // Prints the matrix rows.
    private static void printMatrix(int[][] matrix) {
        // Print each row on a separate line.
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
