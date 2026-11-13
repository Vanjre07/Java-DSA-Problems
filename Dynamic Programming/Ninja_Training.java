import java.util.*;
public class Ninja_Training {
    public static int Training(int[][]points){
        int n = points.length;

        int [][]dp = new int[n][4];

        for(int[]row : dp){
            Arrays.fill(row,-1);
        }

        return Recurssion(n - 1,3,points,dp);
    }

    public static int Recurssion(int day,int last,int[][]points,int[][]dp){
        if(day == 0){
            int max = 0;
            for(int task = 0; task < 3; task++){
                if(task != last){
                    max = Math.max(max, points[day][last]);
                }
            }
            dp[day][last] = max;
            return dp[day][last];
        }

        int max = 0;
        if(dp[day][last] != -1)
            return dp[day][last];

        for(int task = 0; task < 3; task++){
            if(task != last){
                int num = points[day][task] + Recurssion(day - 1,task,points,dp);
                max = Math.max(max,num);
            }
        }
        dp[day][last] = max;
        return dp[day][last];
    }

    public static void main(String[] args) {
        int[][]points = {{10, 40, 70},
                        {20, 50, 80},
                        {30, 60, 90}};

        System.out.print(Training(points));
    }
}
