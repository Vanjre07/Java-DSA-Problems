import java.util.*;
public class Job_Sequence_Problem {

    public static int[] JobScheduling(int[][]Jobs){
        int n = Jobs.length;
        Arrays.sort(Jobs,(a,b) -> Integer.compare(b[2],a[2]));

        int count = 0;
        int totalProfit = 0;
        int MaxDeadLine = -1;

        for(int index = 0; index < n; index++){
            MaxDeadLine = Math.max(MaxDeadLine,Jobs[index][1]);
        }

        int[]Hash = new int[MaxDeadLine + 1];
        Arrays.fill(Hash,-1);

        for(int index = 0; index < n; index++){
            for(int job = Jobs[index][1]; job > 0; job--){
                if(Hash[job] == -1){
                    count++;
                    Hash[job] = Jobs[index][0];
                    totalProfit += Jobs[index][2];
                    break;
                }
            }
        }
        return new int[]{count,totalProfit};
    }
    public static void main(String[] args) {
        int[][]Jobs = { {1, 4, 20} ,
                        {2, 1, 10} ,
                        {3, 1, 40} ,
                        {4, 1, 30}};

        System.out.print(Arrays.toString(JobScheduling(Jobs)));
    }
}
