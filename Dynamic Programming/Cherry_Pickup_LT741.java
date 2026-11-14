import java.util.*;
public class Cherry_Pickup_LT741 {
    private static final int IMPOSSIBLE = -100_000;

    public static int cherryPickup(int[][] grid) {
        int size = grid.length;
        if (size == 0) return 0;

        int[][][][] memo = new int[size][size][size][size];

        for (int[][][] firstRow : memo) {
            for (int[][] secondRow : firstRow) {
                for (int[] thirdRow : secondRow) {
                    Arrays.fill(thirdRow, IMPOSSIBLE);
                }
            }
        }

        return Math.max(0, collectCherries(0, 0, 0, 0, size, grid, memo));
    }

    private static int collectCherries(int firstRow, int firstCol,
                                       int secondRow, int secondCol,
                                       int size, int[][] grid, int[][][][] memo) {
        if (firstRow >= size || firstCol >= size || secondRow >= size || secondCol >= size)
            return IMPOSSIBLE;

        if (grid[firstRow][firstCol] == -1 || grid[secondRow][secondCol] == -1)
            return IMPOSSIBLE;

        if (firstRow == size - 1 && firstCol == size - 1)
            return grid[firstRow][firstCol];

        if (memo[firstRow][firstCol][secondRow][secondCol] != IMPOSSIBLE)
            return memo[firstRow][firstCol][secondRow][secondCol];

        int cherries = grid[firstRow][firstCol];
        if (firstRow != secondRow || firstCol != secondCol)
            cherries += grid[secondRow][secondCol];

        int bothDown = collectCherries(firstRow + 1, firstCol, secondRow + 1, secondCol, size, grid, memo);
        int firstDownSecondRight = collectCherries(firstRow + 1, firstCol, secondRow, secondCol + 1, size, grid, memo);
        int firstRightSecondDown = collectCherries(firstRow, firstCol + 1, secondRow + 1, secondCol, size, grid, memo);
        int bothRight = collectCherries(firstRow, firstCol + 1, secondRow, secondCol + 1, size, grid, memo);

        int bestNext = Math.max(Math.max(bothDown, firstDownSecondRight),
                                Math.max(firstRightSecondDown, bothRight));
        memo[firstRow][firstCol][secondRow][secondCol] = cherries + bestNext;

        return memo[firstRow][firstCol][secondRow][secondCol];
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, -1},
            {1, 0, -1},
            {1, 1, 1}
        };

        System.out.print(cherryPickup(grid));
    }
}

