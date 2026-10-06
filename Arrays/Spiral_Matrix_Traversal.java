import java.util.*;
public class Spiral_Matrix_Traversal {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;

        List<Integer> list = new ArrayList<>();

        while (top <= bottom && left <= right) {
            //Left -> right
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            //top -> bottom
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            //left -> right

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //bottom -> top

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;

    }
    public static void main(String[]args){

    }
}
