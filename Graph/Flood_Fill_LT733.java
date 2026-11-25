import java.util.*;
public class Flood_Fill_LT733 {

    public static int[][]Flood(int[][]image,int sr,int sc,int NewColor){
        int n = image.length;
        int m = image[0].length;

        int[]delrow = {-1,0,1,0};
        int[]delcol = {0,1,0,-1};

        int[][]ans = image;
        int iniColor = image[sr][sc];

        dfs(sr,sc,ans,image,n,m,iniColor,NewColor,delrow,delcol);

        return ans;
    }

    public static void dfs(int row,int col,int[][]ans,int[][]image,int n,int m,int iniColor,int NewColor,int[]delrow,int[]delcol){
        ans[row][col] = NewColor;

        for(int i = 0; i < 4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow >= 0 && nrow < n
            && ncol >= 0 && ncol < m
            && image[nrow][ncol] == iniColor && image[nrow][ncol] != NewColor){
                dfs(nrow,ncol,ans,image,n,m,iniColor,NewColor,delrow,delcol);
            }
        }
    }
    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        int[][] result = Flood(image, sr, sc, color);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
