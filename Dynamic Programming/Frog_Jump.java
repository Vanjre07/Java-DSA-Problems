import java.util.*;
public class Frog_Jump {
    public static int Frog_Jump(int []height){
        int n = height.length;
        int[]dp = new int[n + 1];
        Arrays.fill(dp,-1);
        return Recurssion(height,n - 1,dp);
    }

    public static int Recurssion(int[]height,int n,int[]dp){
        if(n == 0) return 0;

        int left = Recurssion(height, n - 1,dp) + Math.abs(height[n - 1] - height[n]);
        int right = Integer.MAX_VALUE;
        if(n > 1)
            right = Recurssion(height,n - 2,dp) + Math.abs(height[n - 2] - height[n]);

        return Math.min(left,right);
    }
    public static void main(String[] args) {
        int[]height = {0,2,5,6,7};
        System.out.print(Frog_Jump(height));
    }
}
