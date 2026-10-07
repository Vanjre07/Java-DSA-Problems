import java.util.*;
public class Rotate_Matrix_90D_LT48 {

    //Brute force
    static class Brute_Force {
        public static void RotateImage(int[][] matrix) {
            int n = matrix.length;
            int[][] ans = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    ans[col][n - 1 - row] = matrix[row][col];
                }
            }
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = ans[row][col];
                }
            }
        }
    }

    //Optimal Solution
    static class Optimal_Sol{
        public static void RotateImage(int[][]matrix){
            int n = matrix.length;

            for(int  row=0; row<n-1; row++){
                for(int col = row+1; col < n; col++){
                    int temp = matrix[row][col];
                    matrix[row][col] = matrix[col][row];
                    matrix[col][row] = temp;
                }
            }

            for(int row = 0; row < n; row++){
                Reverse(matrix[row]);
            }
        }

        public static void Reverse(int[] matrix){
            int left = 0;
            int right = matrix.length - 1;

            while(left < right){
                int temp = matrix[left];
                matrix[left] = matrix[right];
                matrix[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
//        Brute_Force.RotateImage(matrix);
        printMatrix(matrix);
        System.out.println();
        Optimal_Sol.RotateImage(matrix);
        printMatrix(matrix);

    }

    // Prints the matrix row by row.
    private static void printMatrix(int[][] matrix) {
        // Print each row in array form.
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
